package com.sparta.eng87.finalproject.controllers;

import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import com.sparta.eng87.finalproject.services.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseTypeController {
    private CourseTypeService courseTypeService;


    @Autowired
    public CourseTypeController(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }


    @GetMapping("/addCourseType")
    public String getAddCourseTypePage() {
        return "addCourseType";
    }

    @PostMapping("/addCourseType")
    public String addBook(@RequestParam(name = "course-type-name") String typeName) {
        CourseTypeEntity courseTypeEntity = new CourseTypeEntity();
        courseTypeEntity.setTypeName(typeName);
        courseTypeService.addCourseType(courseTypeEntity);
        return "redirect:/extraCourseInfoPage";
    }

    @GetMapping("/editCourseType/{id}")
    public String updateCourseType(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("course_type", courseTypeService.findCourseTypeById(id));
        return "editCourseType";
    }

    @PostMapping("/updateCourseType/{id}")
    public String updateCourseType(CourseTypeEntity courseTypeEntity, @PathVariable("id") Integer id) {
        courseTypeEntity.setCourseTypeId(id);
        courseTypeService.addCourseType(courseTypeEntity);
        return "redirect:/extraCourseInfoPage";
    }

    @GetMapping("/deleteCourseType/{id}")
    public String deleteCourseType(@PathVariable("id") Integer id) {
        //bookService.deleteBook(id);
        courseTypeService.deleteCourseType(id);
        return "redirect:/extraCourseInfoPage";
    }
}
