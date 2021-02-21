//package com.laioffer.travel_planner_backend.service;
//
//import com.laioffer.travel_planner_backend.dao.UserDao;
//import com.laioffer.travel_planner_backend.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserDao userDao;
//
//    @Transactional
//    public void addUser(User user) {
//        userDao.addUser(user);
//    }
//
//    @Transactional
//    public User getByUserName(String userName) {
//        return userDao.getByUserName(userName);
//    }
//}
