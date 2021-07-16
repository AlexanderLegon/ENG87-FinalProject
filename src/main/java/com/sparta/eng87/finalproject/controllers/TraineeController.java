package com.sparta.eng87.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraineeController {

    @GetMapping("/addTrainee")
    public String getAddTraineePage() {
        return "addTrainee";
    }
}
