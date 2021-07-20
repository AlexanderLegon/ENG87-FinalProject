package com.sparta.eng87.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.services.LocationService;

@Controller
public class FragmentController {

    private LocationService locationService;

    public FragmentController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/accountManagement")
    public String goToAbout(){
        return "accountManagement";
    }

    @GetMapping("/login")
    public String goToLogin(){
        return "login";
    }

    @GetMapping("/traineePage")
    public String goToTrainee(){
        return "traineePage";
    }

    @GetMapping("/trainerPage")
    public String goToTrainer(){
        return "trainerPage";
    }

    @GetMapping("/coursePage")
    public String goToCourse(){
        return "coursePage";
    }

    @GetMapping("/centres")
    public String goToCentre(Model model){
        model.addAttribute("locations", locationService.getAllLocations());
        return "centres";
    }

}
