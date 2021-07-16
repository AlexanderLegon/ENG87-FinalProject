package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.repositories.CourseTypeRepository;
import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
