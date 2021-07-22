package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseTypeEntity, Integer> {

    @Query(value = "SELECT * FROM course_type ct", nativeQuery = true)
    List<Object[]> getAllCourseTypes();

    @Query(value = "SELECT * FROM course_type", nativeQuery = true)
    List<CourseTypeEntity> getAllCourseTypeEntities();

}
