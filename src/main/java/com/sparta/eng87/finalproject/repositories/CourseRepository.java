package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    CourseEntity getCourseEntityByCourseName(String courseName);

    @Query(value="SELECT * FROM course", nativeQuery = true)
    List<CourseEntity> getAllCourses();
}
