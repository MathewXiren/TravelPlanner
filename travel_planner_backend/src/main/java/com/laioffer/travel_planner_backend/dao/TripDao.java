package com.laioffer.travel_planner_backend.dao;

import com.laioffer.travel_planner_backend.entity.Place;
import com.laioffer.travel_planner_backend.entity.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Set;

@Repository
public class TripDao {

    @Autowired
    private EntityManager entityManager;

    public Trip getTripById(long tripId) {
        Trip trip = null;
        try (Session session = entityManager.unwrap(Session.class)) {
            trip = session.get(Trip.class, tripId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trip;
    }

    public void addTrip(Trip trip) {
        Session session = null;
        try {
            session = entityManager.unwrap(Session.class);
            session.beginTransaction();
            session.save(trip);
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

    public void deleteTrip(long tripId) {
        Session session = null;
        try {
            session = entityManager.unwrap(Session.class);
            session.beginTransaction();
            Trip trip = session.get(Trip.class, tripId);
            session.delete(trip);
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

    public void updateTrip(Trip trip) {
        Session session = null;
        try {
            session = entityManager.unwrap(Session.class);
            session.beginTransaction();
            session.saveOrUpdate(trip);
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

    public void addPlace(long tripId, Place place) {
        Trip trip = getTripById(tripId);
        trip.addPlace(place);
        updateTrip(trip);
    }

    public Place getPlace(long tripId, String placeId) {
        Trip trip = getTripById(tripId);
        Set<Place> places = trip.getPlaces();
        for (Place place : places) {
            if (place.getPlaceId().equals(placeId)) {
                return place;
            }
        }
        return null;
    }


    public void deletePlace(long tripId, String placeId) {
        Trip trip = getTripById(tripId);
        Place place = getPlace(tripId, placeId);
        trip.deletePlace(place);
        updateTrip(trip);
    }

    public Trip getTripByTripName(String tripName) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.get(Trip.class, tripName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


//    public List<Trip> getAllTrip(User userName) {
//        List<Trip> trips = new ArrayList<>();
//        try(Session session = sessionFactory.openSession()) {
//            trips = session.createCriteria(Trip.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    public Trip validate(int tripId) throws IOException {
//        Trip trip = getTripById(tripId);
//        if (trip == null || trip.get)
//    }


}
