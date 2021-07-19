package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.services.CourseService;
import com.sparta.eng87.finalproject.services.TrainerService;
import com.sparta.eng87.finalproject.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ScheduleController {
    private ScheduleService scheduleService;
    private CourseService courseService;
    private TrainerService trainerService;

    @Autowired
    public ScheduleController(CourseService courseService, TrainerService trainerService, ScheduleService scheduleService) {
        this.courseService = courseService;
        this.trainerService = trainerService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/")
    public String goToScheduler(Model model){

        model.addAttribute("CourseName", courseService.getCourseNames());
        model.addAttribute("DisciplineName", courseService.getDisciplineNames());
        model.addAttribute("CourseTypeName", courseService.getCourseTypeNames());
        model.addAttribute("TrainerName", courseService.getTrainerNames());
        model.addAttribute("LocationName", courseService.getLocations());
        model.addAttribute("CourseStartDate", courseService.getListOfStringFromDates(courseService.getCourseStartDates()));
        model.addAttribute("DisciplineDuration", courseService.getDisciplineDurations());
        model.addAttribute("CourseEndDate", courseService.getListOfStringFromDates(courseService.getCourseEndDate()));
        model.addAttribute("BondDate", courseService.getListOfStringFromDates(courseService.getBonds()));
        model.addAttribute("color", trainerService.getListOfTrainerColor(courseService.getTrainerNames()));

        List<String> dates = scheduleService.listDates();
        model.addAttribute("dates", dates);
        return "schedulerPage";
    }
}
