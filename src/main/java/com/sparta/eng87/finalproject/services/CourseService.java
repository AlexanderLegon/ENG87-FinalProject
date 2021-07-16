package com.sparta.eng87.finalproject.services;


import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(CourseEntity courseEntity){
        courseRepository.save(courseEntity);

    }
}
