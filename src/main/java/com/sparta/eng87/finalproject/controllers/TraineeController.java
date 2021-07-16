package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.entities.TraineeEntity;
import com.sparta.eng87.finalproject.services.CourseService;
import com.sparta.eng87.finalproject.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TraineeController {

    private CourseService courseService;
    private TraineeService traineeService;

    @Autowired
    public TraineeController(CourseService courseService, TraineeService traineeService) {
        this.courseService = courseService;
        this.traineeService = traineeService;
    }

    @GetMapping("/addTrainee")
    public String getAddTraineePage(Model model) {
        List<CourseEntity> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "addTrainee";
    }

    @PostMapping("/addTrainee")
    public String addTrainee(@RequestParam(name = "trainee-course-name") String courseName,
                             @RequestParam(name = "trainee-first-name") String firstName,
                             @RequestParam(name = "trainee-last-name") String lastName) {
        CourseEntity course = courseService.getCourseEntityByCourseName(courseName);
        Integer courseId = course.getCourseId();
        TraineeEntity traineeEntity = new TraineeEntity();
        traineeEntity.setCourseId(courseId);
        traineeEntity.setFirstName(firstName);
        traineeEntity.setLastName(lastName);
        traineeService.addTrainee(traineeEntity);
        return "redirect:/addTrainee";
    }

    @GetMapping("/editTrainee/{id}")
    public String getEditTraineePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("trainee",traineeService.getTraineeById(id));
        List<CourseEntity> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "editTrainee";
    }

    @PostMapping("/editTrainee/{id}")
    public String editTrainee(@PathVariable("id") Integer id, TraineeEntity traineeEntity) {
        traineeEntity.setTraineeId(id);
        traineeService.addTrainee(traineeEntity);
        return "redirect:/addTrainee";
    }

    @GetMapping("/deleteTrainee/{id}")
    public String deleteTrainee(@PathVariable("id") Integer id, TraineeEntity traineeEntity) {
        traineeService.deleteTrainee(id);
        return "redirect:/addTrainee";
    }
}
