package com.laioffer.travel_planner_backend.dao;

import com.laioffer.travel_planner_backend.entity.Day;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DayDao {


    @Autowired
    private EntityManager entityManager;

    public Day getDayById(long dayId) {
        Day day = null;
        try (Session session = entityManager.unwrap(Session.class)) {
            day = session.get(Day.class, dayId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    public void update(Day day) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.beginTransaction();
            session.saveOrUpdate(day);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

