package com.sparta.eng87.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    public controller() {
    }


    @GetMapping("/")
    public String g(){
        return "index";
    }
}
