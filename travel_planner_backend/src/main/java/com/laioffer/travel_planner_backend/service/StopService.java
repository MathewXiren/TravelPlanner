package com.laioffer.travel_planner_backend.service;

import com.laioffer.travel_planner_backend.dao.StopDao;
import com.laioffer.travel_planner_backend.entity.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StopService {

    @Autowired
    private StopDao stopDao;

    @Transactional
    public Stop getStopById(long stopId) {
        return stopDao.getStopById(stopId);
    }

}