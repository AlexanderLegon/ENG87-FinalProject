package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import com.sparta.eng87.finalproject.entities.CourseTrainerDatesEntity;
import com.sparta.eng87.finalproject.repositories.CourseTrainerDatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseTrainerDatesService {
    private CourseTrainerDatesRepository courseTrainerDatesRepository;

    @Autowired
    public CourseTrainerDatesService(CourseTrainerDatesRepository courseTrainerDatesRepository) {
        this.courseTrainerDatesRepository = courseTrainerDatesRepository;
    }

    public void addCourse(CourseTrainerDatesEntity courseTrainerDatesEntity) {
        courseTrainerDatesRepository.save(courseTrainerDatesEntity);
    }
}
