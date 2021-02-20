package com.laioffer.travel_planner_backend.dao;

import com.laioffer.travel_planner_backend.entity.Place;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PlaceDao {
    @Autowired
    private EntityManager entityManager;


    public void addPlace(Place place) {
        Session session = null;
//        session.save(place);
//
        try {
            session = entityManager.unwrap(Session.class);
            session.beginTransaction();
            session.save(place);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void deletePlace(String placeId) {
        Session session = null;
        try {
            session = entityManager.unwrap(Session.class);
            session.beginTransaction();
            Place place = session.get(Place.class, placeId);
            session.delete(place);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updatePlace(Place place) {
        Session session = null;
        try {
            session = entityManager.unwrap(Session.class);
            session.beginTransaction();
            session.saveOrUpdate(place);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Place getPlaceById(String placeId) {
        Place place = null;
        try (Session session =  entityManager.unwrap(Session.class);) {
            place = session.get(Place.class, placeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return place;
    }
}
