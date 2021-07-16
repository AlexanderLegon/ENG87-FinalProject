package com.sparta.eng87.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {

    public FragmentController() {
    }

    @GetMapping("/")
    public String goToScheduler(){
        return "schedulerPage";
    }

    @GetMapping("/about")
    public String goToAbout(){
        return "aboutPage";
    }

    @GetMapping("/login")
    public String goToLogin(){
        return "loginPage";
    }


}
