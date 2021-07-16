package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TraineeController {

    private TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @Autowired


    @GetMapping("/addTrainee")
    public String getAddTraineePage() {
        return "addTrainee";
    }

    @GetMapping("/traineePage/{courseName}")
    public String displayTraineesForCourseId(@PathVariable("courseName") String courseName, Model model)
    {

        model.addAttribute("courseName", courseName);
        model.addAttribute("trainees", traineeService.findTraineeByCourse(courseName));

        return "traineePage";
    }





}
