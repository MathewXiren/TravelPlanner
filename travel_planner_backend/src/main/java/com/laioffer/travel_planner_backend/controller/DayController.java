package com.laioffer.travel_planner_backend.controller;

import com.laioffer.travel_planner_backend.entity.Day;
import com.laioffer.travel_planner_backend.entity.Place;
import com.laioffer.travel_planner_backend.entity.Stop;
import com.laioffer.travel_planner_backend.entity.StopType;
import com.laioffer.travel_planner_backend.message.response.RouteResponse;
import com.laioffer.travel_planner_backend.service.DayService;
import com.laioffer.travel_planner_backend.service.PlaceService;
import com.laioffer.travel_planner_backend.service.StopService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DayController {
    
    @Autowired
    private DayService dayService;
    
    @Autowired
    private PlaceService placeService;
    
    @Autowired
    private StopService stopService;
    
    @PostMapping(value = "/trip/newDay")
    public Day newDay(@RequestParam long tripId) {
        return dayService.newDay(tripId);
    }
    
    @GetMapping(value = "/trip/day")
    public Day getDayById(@RequestParam long dayId) {
        return dayService.getDayById(dayId);
    }
    
    @PostMapping(value = "/trip/day/place", params = {"dayId", "placeId"})
    public Stop addPlace(@RequestParam long dayId, @RequestParam String placeId) {
        Day day = dayService.getDayById(dayId);
        Place place = placeService.getPlaceById(placeId);
        return dayService.addPlace(day, place);
    }
    
    @DeleteMapping(value = "/trip/day/place", params = {"dayId", "placeId"})
    public String deletePlace(@RequestParam long dayId, @RequestParam String placeId) {
        Day day = dayService.getDayById(dayId);
        Place place = placeService.getPlaceById(placeId);
        dayService.deletePlace(day, place);
        return "redirect:/getAllDays";
    }
    
    @DeleteMapping(value = "/trip/day/stop", params = {"dayId", "stopId"})
    public String deleteStop(@RequestParam long dayId, @RequestParam long stopId) {
        Day day = dayService.getDayById(dayId);
        Stop stop = stopService.getStopById(stopId);
        dayService.deleteStop(day, stop);
        return "redirect:/getAllDays";
    }
    
    @PostMapping("/trip/day/route/gen")
    public List<Stop> genRoute(@RequestParam long dayId) {
        Day day = dayService.getDayById(dayId);
        return dayService.generateDayPath(day);
    }
    
    @GetMapping(value = "/trip/day/route")
    public ResponseEntity<?> getRoute(@RequestParam long dayId) {
        Day day = dayService.getDayById(dayId);
        List<Stop> route = day.getRoute();
        return ResponseEntity.ok(new RouteResponse(route));
    }


    
    @PostMapping(value = "/trip/day/route")
    public String setRoute(@RequestBody List<Long> stopIdLst, BindingResult result,
        @RequestParam long dayId) {
        if (result.hasErrors()) {
            return "setRoute";
        }
        List<Stop> route = new ArrayList<>();
        for (long stopId : stopIdLst) {
            route.add(stopService.getStopById(stopId));
        }
        Day day = dayService.getDayById(dayId);
        dayService.setRoute(day, route);
        return "redirect:/getAllDays";
    }
    
    @PostMapping(value = "/trip/day/stop/type")
    public String setStopFuncType(@RequestBody Map<Long, StopType> stopTypes,
        BindingResult result) {
        if (result.hasErrors()) {
            return "Set StopType Error";
        }
        for (Map.Entry<Long, StopType> entry : stopTypes.entrySet()) {
            Stop stop = stopService.getStopById(entry.getKey());
            stop.setType(entry.getValue());
            stopService.update(stop);
        }
        return "redirect:/getAllDays";
    }
    
}
