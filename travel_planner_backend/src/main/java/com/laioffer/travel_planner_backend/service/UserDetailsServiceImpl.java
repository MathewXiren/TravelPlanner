package com.laioffer.travel_planner_backend.service;


import com.laioffer.travel_planner_backend.dao.UserDao;
import com.laioffer.travel_planner_backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        User user = userDao.getByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("User Not Found with -> username or email : " + username);
        }

        return UserPrinciple.build(user);
    }
}