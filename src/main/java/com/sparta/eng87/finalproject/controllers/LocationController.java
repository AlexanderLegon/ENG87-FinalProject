package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/addLocation")
    public String getAddLocationPage() {
        return "addLocation";
    }

    @PostMapping("/addLocation")
    public String addLocation(@RequestParam(name = "location-location") String location,
                              @RequestParam(name = "location-no-of-rooms") Integer noOfRooms) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLocation(location);
        locationEntity.setNumberOfRooms(noOfRooms);
        locationService.addLocation(locationEntity);
        return "redirect:/";
    }

    @GetMapping("/editLocation/{id}")
    public String editLocation(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("location", locationService.findLocationById(id));
        return "editLocation";
    }

    @PostMapping("/update/{id}")
    public String updateLocation(LocationEntity locationEntity,
                                 @PathVariable("id") Integer id) {
        locationEntity.setLocationId(id);
        locationService.addLocation(locationEntity);
        return "redirect:/";
    }

    @GetMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable("id") Integer id) {
        locationService.deleteLocation(id);
        return "redirect:/";
    }


}
