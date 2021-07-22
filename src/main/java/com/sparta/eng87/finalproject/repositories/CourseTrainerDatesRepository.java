package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.CourseTrainerDatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTrainerDatesRepository extends JpaRepository<CourseTrainerDatesEntity, Integer> {


    @Query(value = "SELECT * FROM course_trainer_dates WHERE course_id = ?1", nativeQuery = true)
    List<CourseTrainerDatesEntity> GetTrainersByCourseId(int courseId);

    @Query(value = "SELECT course_trainer_dates_id FROM course_trainer_dates WHERE course_id = ?1", nativeQuery = true)
    Integer[] getTrainersDateIdByCourseId(int courseId);

}
