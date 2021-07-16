package com.sparta.eng87.finalproject.services;


import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public CourseEntity findCourseById(Integer id){
        return courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid ID")
        );
    }

    public void removeCourse(Integer id){
        courseRepository.deleteById(id);
    }

    public CourseEntity getCourseEntityByCourseName(String courseName) {
        return courseRepository.getCourseEntityByCourseName(courseName);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.getAllCourses();
    }
}
