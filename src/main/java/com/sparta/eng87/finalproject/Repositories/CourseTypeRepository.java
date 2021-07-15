package com.sparta.eng87.finalproject.Repositories;

import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepository extends JpaRepository <CourseTypeEntity,Integer> {
}
