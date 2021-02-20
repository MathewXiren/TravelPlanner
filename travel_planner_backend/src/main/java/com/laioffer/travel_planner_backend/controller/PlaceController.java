package com.laioffer.travel_planner_backend.controller;


import com.laioffer.travel_planner_backend.entity.Place;
import com.laioffer.travel_planner_backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @PostMapping("place/addPlace")
    public String addPlace(@RequestBody Place place, BindingResult result) {
        if (result.hasErrors()) {
            return "addPlace";
        }
        placeService.addPlace(place);
        return "redirect:/getAllPlace";
    }

    @DeleteMapping("place/{placeId}")
    public String deletePlace(@PathVariable(value = "placeId") String placeId) {
        placeService.deletePlace(placeId);
        return "redirect:/getAllPlace";
    }

    @GetMapping("place/{placeId}")
    public String searchPlaceById(@PathVariable(value = "placeId") String placeId) {
        placeService.searchPlaceById(placeId);
        // TODO: to complete and return actual place objects
        return "redirect:/getAllPlace";
    }

    @GetMapping("place/{name}")
    public String searchPlaceByName(@PathVariable(value = "name") String name) {
        placeService.searchPlaceByName(name);
        // TODO: to complete and return list of actual place objects
        return "redirect:/getAllPlace";
    }

}