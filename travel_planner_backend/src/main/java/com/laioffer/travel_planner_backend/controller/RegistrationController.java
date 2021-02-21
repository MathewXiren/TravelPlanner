//package com.laioffer.travel_planner_backend.controller;
//
//import com.laioffer.travel_planner_backend.entity.User;
//import com.laioffer.travel_planner_backend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class RegistrationController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping(value = "/register")
//    public String registerUser(@RequestBody User user,
//                                         BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "Register error";
//        }
//        System.out.print(user);
//        userService.addUser(user);
//        System.out.print("done");
//        return "redirect:/index";
//    }
//}
