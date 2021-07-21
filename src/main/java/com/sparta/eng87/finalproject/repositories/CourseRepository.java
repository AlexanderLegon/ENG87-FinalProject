package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    @Query(value="SELECT c.course_name, d.discipline_name, ct.type_name, t.first_name, t.last_name, l.location, c.start_date, d.discipline_duration, c.course_id, count(tr.trainee_id)" +
            "FROM course c INNER JOIN discipline d " +
            "ON c.discipline_id = d.discipline_id " +
            "INNER JOIN course_type ct " +
            "ON c.type_id = ct.course_type_id " +
            "INNER JOIN trainer t " +
            "ON c.trainer_id = t.trainer_id " +
            "INNER JOIN location l " +
            "ON l.location_id = c.location_id " +
            "LEFT JOIN trainee tr " +
            "ON tr.course_id = c.course_id " +
            "group by course_id " +
            "ORDER BY c.start_date", nativeQuery = true)

    List<Object[]> getAllCoursesByArray();

    CourseEntity getCourseEntityByCourseName(String courseName);

    @Query(value="SELECT * FROM course", nativeQuery = true)
    List<CourseEntity> getAllCourses();

    @Query(value = "SELECT course_id FROM course WHERE course_name = ?1" ,nativeQuery = true)
    int findCourseIdByCourseName(String courseName);

    @Query(value = "SELECT start_date FROM course WHERE course_name = ?1" ,nativeQuery = true)
     String getCourseStartDatesByCourseName(String courseName);

    @Query(value ="SELECT * FROM course_trainer_dates WHERE course_id=?1" ,nativeQuery = true)
    List<Object[]> getTrainerDatesByCourseId(Integer course_id);
}
