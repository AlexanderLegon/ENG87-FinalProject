package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity, Integer> {


    @Query(value = "SELECT * FROM trainee WHERE course_id = ?1",nativeQuery = true)
    List<TraineeEntity> findAllByCourseId(int courseId);


//    @Query(value="SELECT t.first_name, t.last_name, q.quality_gate_status, t.trainee_id FROM trainee t LEFT JOIN quality_gate q ON t.trainee_id = q.trainee_id WHERE course_id = ?1" , nativeQuery = true)
//     List<Object[]> getTraineesByCourseId(int id);

    @Query(value="SELECT t.first_name, t.last_name, q.quality_gate_status, t.trainee_id, c.course_name  FROM trainee t " +
            "LEFT JOIN quality_gate q ON t.trainee_id = q.trainee_id " +
            "INNER JOIN course c ON t.course_id = c.course_id " +
            "WHERE t.course_id = ?1 " , nativeQuery = true)
    List<Object[]> getTraineesByCourseId(int id);

    @Query(value="SELECT t.first_name, t.last_name, q.quality_gate_status, t.trainee_id, c.course_name FROM trainee t " +
            "LEFT JOIN quality_gate q ON t.trainee_id = q.trainee_id " +
            "INNER JOIN course c ON t.course_id = c.course_id ", nativeQuery = true)
    List<Object[]> getAllTrainees();
}
