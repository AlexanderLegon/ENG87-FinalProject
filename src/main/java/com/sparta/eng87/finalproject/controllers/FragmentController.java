package com.sparta.eng87.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {

    public FragmentController() {
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
    public String goToCentre(){
        return "centres";
    }

}
