//package com.laioffer.travel_planner_backend.dao;
//
//import com.laioffer.travel_planner_backend.entity.User;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//
//@Repository
//public class UserDao {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public void addUser(User user) {
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(user);
//        System.out.println("after" + user);
//    }
//
//    public User getByUserName(String userName) {
//        Session session = entityManager.unwrap(Session.class);
//        User user = session.get(User.class, userName);
//        return user;
//    }
//
//    public User getByEmail(String email) {
//        Session session = entityManager.unwrap(Session.class);
//        User user = session.get(User.class, email);
//        return user;
//    }
//
//    public boolean existsByUsername(String userName) {
//        User user = getByUserName(userName);
//        return user == null ? false : true;
//    }
//
//    public boolean existsByEmail(String email) {
//        User user = getByEmail(email);
//        return user == null ? false : true;
//    }
//
//}
