//package com.laioffer.travel_planner_backend.controller;
//
//import com.laioffer.travel_planner_backend.entity.User;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@RestController
//public class HomePageController {
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String sayIndex() {
//        return "index";//view name
//    }
//    // /login?error
//    // /login?logout
//    // /login
////    @RequestMapping("/login")
//    @GetMapping(path="/login")
//    public String login(@RequestParam(value = "error", required = false) String error,
//                        @RequestParam(value = "logout", required = false) String logout) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("login");
////        System.out.println(user);
//
//        if (error != null) {
//            System.out.println("error: " + error);
//            return error  + "Invalid username and Password";
//        }
//
//        if (logout != null) {
//            return "logout, " + "You have logged out successfully";
//        }
//
//        return "emailId: 0";
//    }
//
//    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
//    public String sayAbout() {
//        return "aboutUs";
//    }
//}
