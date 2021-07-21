package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.repositories.CourseTypeRepository;
import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseTypeService {

    private CourseTypeRepository courseTypeRepository;

    @Autowired
    public CourseTypeService (CourseTypeRepository courseTypeRepository){
        this.courseTypeRepository = courseTypeRepository;
    }

    public void addCourseType(CourseTypeEntity courseTypeEntity){
        courseTypeRepository.save(courseTypeEntity);
    }

    public CourseTypeEntity findCourseTypeById(Integer id){
        return courseTypeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid Course Type ID " + id)
        );
    }

    public void deleteCourseType(Integer id){
        courseTypeRepository.deleteById(id);
    }

    public List<Object[]> getAllCourseTypes(){
        return courseTypeRepository.getAllCourseTypes();
    }

    public List<CourseTypeEntity> getAllCourseTypeEntities() {
        return courseTypeRepository.getAllCourseTypeEntities();
    }

}
