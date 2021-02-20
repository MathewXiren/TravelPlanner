package com.laioffer.travel_planner_backend.controller;


import com.laioffer.travel_planner_backend.dao.RoleDao;
import com.laioffer.travel_planner_backend.dao.UserDao;
import com.laioffer.travel_planner_backend.entity.Role;
import com.laioffer.travel_planner_backend.entity.RoleType;
import com.laioffer.travel_planner_backend.entity.User;
import com.laioffer.travel_planner_backend.message.request.LoginForm;
import com.laioffer.travel_planner_backend.message.request.SignUpForm;
import com.laioffer.travel_planner_backend.message.response.JwtResponse;
import com.laioffer.travel_planner_backend.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpForm signUpRequest) {
        if(userDao.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userDao.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getEmail(), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleDao.findByName(RoleType.ROLE_ADMIN);
	    			if (adminRole == null) {
	    			    throw new RuntimeException("Fail! -> Cause: User Role not find.");
                    }
	    			roles.add(adminRole);
	    			break;
	    		case "pm":
	            	Role pmRole = roleDao.findByName(RoleType.ROLE_PM);
                    if (pmRole == null) {
                        throw new RuntimeException("Fail! -> Cause: User Role not find.");
                    }
	            	roles.add(pmRole);
	            	
	    			break;
	    		default:
	        		Role userRole = roleDao.findByName(RoleType.ROLE_USER);
                    if (userRole == null) {
                        throw new RuntimeException("Fail! -> Cause: User Role not find.");
                    }
                    roles.add(userRole);
        	}
        });
        
        user.setRoles(roles);
        userDao.addUser(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}