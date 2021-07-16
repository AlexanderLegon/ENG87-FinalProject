package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/addCourse")
    public String getAddCoursePage(){
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestParam(name = "course_name") String courseName,
                            @RequestParam(name = "trainer_id") Integer trainerId,
                            @RequestParam(name = "discipline_id") Integer disciplineId,
                            @RequestParam(name = "type_id") Integer typeId,
                            @RequestParam(name = "location_id") Integer locationId,
                            @RequestParam(name = "start_date") String startDate){


        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(courseName);
        courseEntity.setTrainerId(trainerId);
        courseEntity.setDisciplineId(disciplineId);
        courseEntity.setTypeId(typeId);
        courseEntity.setLocationId(locationId);
        courseEntity.setStartDate(Date.valueOf(startDate));

        courseService.addCourse(courseEntity);

        return "redirect:/";
    }

    @GetMapping("/editCourse/{id}")
    public String editCourse(@PathVariable("id") Integer id, Model model){
        model.addAttribute("course", courseService.findCourseById(id));
        return "editCourse";
    }

    @PostMapping("/update-course/{id}")
    public String editCourse(@PathVariable("id") Integer id, CourseEntity courseEntity){
        courseEntity.setCourseId(id);
        courseService.addCourse(courseEntity);
        return "redirect:/";
    }
}
