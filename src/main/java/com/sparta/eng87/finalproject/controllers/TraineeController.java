package com.sparta.eng87.finalproject.controllers;


import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.entities.QualityGateEntity;
import com.sparta.eng87.finalproject.entities.TraineeEntity;
import com.sparta.eng87.finalproject.services.CourseService;

import com.sparta.eng87.finalproject.services.QualityGateService;
import com.sparta.eng87.finalproject.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;


@Controller
public class TraineeController {


    private CourseService courseService;
    private TraineeService traineeService;
    private QualityGateService qualityGateService;

    @Autowired
    public TraineeController(CourseService courseService, TraineeService traineeService, QualityGateService qualityGateService) {
        this.courseService = courseService;
        this.traineeService = traineeService;
        this.qualityGateService = qualityGateService;
    }


    @GetMapping("/addTrainee")
    public String getAddTraineePage(Model model) {
        List<CourseEntity> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "addTrainee";
    }

    @GetMapping("/traineePage/{courseName}")
    public String displayTraineesForCourseId(@PathVariable("courseName") String courseName, Model model)
    {

        model.addAttribute("courseName", courseName);
        model.addAttribute("trainees", traineeService.findTraineeByCourse(courseName));

        return "traineePage";
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
        return "redirect:/";
    }

    @GetMapping("/deleteTrainee/{id}/{courseName}")
    public String deleteTrainee(@PathVariable("id") Integer id, TraineeEntity traineeEntity,
                                @PathVariable("courseName") String courseName, Model model) {
        traineeService.deleteTrainee(id);
        model.addAttribute("courseName", courseName);
        model.addAttribute("trainees", traineeService.findTraineeByCourse(courseName));
        return "redirect:/traineePage/{courseName}";
    }

    @GetMapping("/addQualityGate/{Tid}")
    public String getAddQualityGatePage(@PathVariable("Tid") Integer id, Model model){
        model.addAttribute("Tid", id);
        return "addQualityGate";
    }

    @PostMapping("/addQualityGate/{Tid}")
    public String addQualityGate(@PathVariable("Tid") Integer id,
                                 @PathVariable("qualityGateStatus") String QGS,
                                 @PathVariable("trainerId1") Integer trainerId1,
                                 @PathVariable("trainerId2") Integer trainerId2,
                                 @PathVariable("trainerFeedback1") String trainerFeedback1,
                                 @PathVariable("trainerFeedback2") String trainerFeedback2,
                                 @PathVariable("date") String date){
        QualityGateEntity qualityGateEntity = new QualityGateEntity();
        qualityGateEntity.setTraineeID(id);
        qualityGateEntity.setPass(QGS);
        qualityGateEntity.setTrainer1ID(trainerId1);
        qualityGateEntity.setTrainer2ID(trainerId2);
        qualityGateEntity.setQualityGateDate(Date.valueOf(date));
        qualityGateEntity.setFeedbackTrainer1(trainerFeedback1);
        qualityGateEntity.setFeedbackTrainer2(trainerFeedback2);
        qualityGateService.save(qualityGateEntity);
        return "redirect:/traineePage";
    }
}
