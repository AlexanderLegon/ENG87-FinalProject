package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {

    @Query(value = "SELECT course_id FROM course WHERE course_name = ?1" ,nativeQuery = true)
    int findCourseIdByCourseName(String courseName);

}
