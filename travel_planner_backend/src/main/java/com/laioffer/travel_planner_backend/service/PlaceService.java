package com.laioffer.travel_planner_backend.service;


import com.laioffer.travel_planner_backend.dao.PlaceDao;
import com.laioffer.travel_planner_backend.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaceService {

    @Autowired
    private PlaceDao placeDao;

    @Transactional
    public void addPlace(Place place) {
        placeDao.addPlace(place);
    }

    @Transactional
    public void deletePlace(String placeId) {
        placeDao.deletePlace(placeId);
    }

    @Transactional
    public void updatePlace(Place place) {
        placeDao.updatePlace(place);
    }

    @Transactional
    public Place getPlaceById(String placeId) {
        return placeDao.getPlaceById(placeId);
    }


    public void searchPlaceById(String placeId) {
        //TODO
    }

    public void searchPlaceByName(String name) {
        //TODO
    }
}