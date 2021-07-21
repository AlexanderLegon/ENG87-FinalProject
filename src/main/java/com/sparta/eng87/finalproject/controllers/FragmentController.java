package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class FragmentController {

    private LocationService locationService;
    private TrainerService trainerService;
    private TraineeService traineeService;
    private CourseService courseService;
    private CourseTypeService courseTypeService;
    private DisciplineService disciplineService;
    private QualityGateService qualityGateService;

    @Autowired
    public FragmentController(LocationService locationService, CourseService courseService, TraineeService traineeService, TrainerService trainerService, CourseTypeService courseTypeService, DisciplineService disciplineService, QualityGateService qualityGateService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.locationService = locationService;
        this.courseService = courseService;
        this.courseTypeService = courseTypeService;
        this.disciplineService = disciplineService;
        this.qualityGateService = qualityGateService;
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
    public String goToTrainee(Model model){
        model.addAttribute("trainees", traineeService.getAllTrainees());
        model.addAttribute("qualitygates", qualityGateService.getAllQualityGates());
        model.addAttribute("courses",courseService.getAllCourses());
        return "traineePage";
    }

    @GetMapping("/trainerPage")
    public String goToTrainer(Model model){
        model.addAttribute("trainers", trainerService.getAllTrainers());
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

    @GetMapping("/extraCourseInfoPage")
    public String goToCourseTypes(Model model){
        model.addAttribute("coursetypes", courseTypeService.getAllCourseTypes());
        model.addAttribute("disciplines", disciplineService.getAllDisciplines());
        return "extraCourseInfoPage";
    }

}
