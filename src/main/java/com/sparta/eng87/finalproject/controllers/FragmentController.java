package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.services.LocationService;

@Controller
public class FragmentController {

    private LocationService locationService;
    private CourseService courseService;


    @Autowired
    public FragmentController(LocationService locationService, CourseService courseService) {
        this.locationService = locationService;
        this.courseService = courseService;
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
    public String goToCourse(Model model){
        model.addAttribute("courses", courseService.getAllCoursesObjects());
        return "coursePage";
    }

    @GetMapping("/centres")
    public String goToCentre(Model model){
        model.addAttribute("locations", locationService.getAllLocations());
        return "centres";
    }

}
