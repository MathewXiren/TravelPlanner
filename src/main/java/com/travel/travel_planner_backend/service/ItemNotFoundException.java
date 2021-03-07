package com.travel.travel_planner_backend.service;

public class ItemNotFoundException extends RuntimeException {
    
    public ItemNotFoundException(String err) {
        super(err);
    }
}
