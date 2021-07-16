package com.sparta.eng87.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {

    public FragmentController() {
    }

    @GetMapping("/about")
    public String goToAbout(){
        return "aboutPage";
    }

    @GetMapping("/login")
    public String goToLogin(){
        return "login";
    }


}
