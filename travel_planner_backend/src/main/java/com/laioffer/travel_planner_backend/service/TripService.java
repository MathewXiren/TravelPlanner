package com.laioffer.travel_planner_backend.service;

import com.laioffer.travel_planner_backend.dao.TripDao;
import com.laioffer.travel_planner_backend.entity.Place;
import com.laioffer.travel_planner_backend.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TripService {

    @Autowired
    private TripDao tripDao;

    @Transactional
    public Trip getTripById(long tripId) {
        return tripDao.getTripById(tripId);
    }

    @Transactional
    public void addTrip(Trip trip) {
        tripDao.addTrip(trip);
    }

    @Transactional
    public void deleteTrip(long tripId) {
        tripDao.deleteTrip(tripId);
    }

    @Transactional
    public void updateTrip(Trip trip) {
        tripDao.updateTrip(trip);
    }

    @Transactional
    public void addPlace(long tripId, Place place) {
        tripDao.addPlace(tripId, place);
    }

    @Transactional
    public void deletePlace(long tripId, String placeId) {
        tripDao.deletePlace(tripId, placeId);
    }

}
