//package com.laioffer.travel_planner_backend.dao;
//
//import com.laioffer.travel_planner_backend.entity.Role;
//import com.laioffer.travel_planner_backend.entity.RoleName;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//
//@Repository
//public class RoleDao {
//    @Autowired
//    private EntityManager entityManager;
//
//    public Role findByName(RoleName type) {
//        Session session = entityManager.unwrap(Session.class);
//        Role role = session.get(Role.class, type);
//        System.out.println(role);
//        return role;
//    }
//
//}
