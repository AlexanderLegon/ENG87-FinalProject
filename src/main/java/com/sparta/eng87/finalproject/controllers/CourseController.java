package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.entities.CourseTrainerDatesEntity;
import com.sparta.eng87.finalproject.services.CourseService;
import com.sparta.eng87.finalproject.services.CourseTrainerDatesService;
import com.sparta.eng87.finalproject.services.LocationService;
import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import com.sparta.eng87.finalproject.entities.LocationEntity;
import com.sparta.eng87.finalproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class CourseController {
    private CourseService courseService;
    private TrainerService trainerService;
    private DisciplineService disciplineService;
    private LocationService locationService;
    private CourseTypeService courseTypeService;
    private CourseTrainerDatesService courseTrainerDatesService;

    @Autowired
    public CourseController(DisciplineService disciplineService, TrainerService trainerService, CourseService courseService, LocationService locationService, CourseTrainerDatesService courseTrainerDatesService, CourseTypeService courseTypeService) {
        this.courseService = courseService;
        this.trainerService = trainerService;
        this.disciplineService = disciplineService;
        this.locationService = locationService;
        this.courseTypeService = courseTypeService;
        this.courseTrainerDatesService = courseTrainerDatesService;

    }


    @GetMapping("/addCourse")
    public String getAddCoursePage(Model model){
        model.addAttribute("trainers", trainerService.getAllTrainerEntities());
        model.addAttribute("disciplines", disciplineService.getAllDisciplineEntities());
        model.addAttribute("locations", locationService.getAllLocationEntities());
        model.addAttribute("courseTypes", courseTypeService.getAllCourseTypeEntities());
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestParam(name = "course_name") String courseName,
                            @RequestParam(name = "trainer_id") Integer[] trainerId,
                            @RequestParam(name = "trainer_start_week") Integer[] trainerStartWeek,
                            @RequestParam(name = "trainer_end_week") Integer[] trainerEndWeek,
                            @RequestParam(name = "discipline_id") Integer disciplineId,
                            @RequestParam(name = "type_id") Integer typeId,
                            @RequestParam(name = "location_id") Integer locationId,
                            @RequestParam(name = "start_date") String startDate){


//        Add to course table
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(courseName);
        courseEntity.setTrainerId(trainerId[0]);
        courseEntity.setDisciplineId(disciplineId);
        courseEntity.setLocationId(locationId);
        courseEntity.setTypeId(typeId);
        courseEntity.setStartDate(Date.valueOf(startDate));
        courseService.addCourse(courseEntity);

//        Add to course_trainer_dates table
        for (int i = 0; i < trainerId.length; i++) {
            CourseTrainerDatesEntity courseTrainerDatesEntity = new CourseTrainerDatesEntity();
            courseTrainerDatesEntity.setCourseId(courseEntity.getCourseId());

            courseTrainerDatesEntity.setTrainerId(trainerId[i]);
            courseTrainerDatesEntity.setTrainerStartDate(trainerStartWeek[i]);
            courseTrainerDatesEntity.setTrainerEndDate(trainerEndWeek[i]);

            courseTrainerDatesService.addCourse(courseTrainerDatesEntity);
        }



        return "redirect:/coursePage";

    }

    @GetMapping("/editCourse/{id}")
    public String editCourse(@PathVariable("id") Integer id, Model model){
        model.addAttribute("course", courseService.findCourseById(id));
        model.addAttribute("trainers", trainerService.getAllTrainerEntities());
        model.addAttribute("disciplines", disciplineService.getAllDisciplineEntities());
        model.addAttribute("locations", locationService.getAllLocationEntities());
        model.addAttribute("courseTypes", courseTypeService.getAllCourseTypeEntities());
        return "editCourse";
    }

    @PostMapping("/updateCourse/{id}")
    public String editCourse(@PathVariable("id") Integer id, CourseEntity courseEntity){
        courseEntity.setCourseId(id);
        courseService.addCourse(courseEntity);
        return "redirect:/coursePage";
    }

    @GetMapping("/deleteCourse/{id}")
    public String removeCourse(@PathVariable("id") Integer id){
        courseService.removeCourse(id);
        return "redirect:/coursePage";
    }


    @GetMapping("/getSpacesAtLocation/{locationId}")
    @ResponseBody
    public String getSpacesAtLocation(@PathVariable("locationId") Integer locationId){
        int spacesAtLocation = courseService.getNumberOfRoomsAtLocation(locationId) - courseService.getRoomOccupancyByLocationId(locationId);
        return String.valueOf(spacesAtLocation);
    }
}
