package com.travel.travel_planner_backend.repository;

import com.travel.travel_planner_backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, String> {


}
