package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Integer> {
    @Query(value="SELECT * FROM trainer ORDER BY trainer_id", nativeQuery = true)
    List<Object> getAllTrainers();

    @Query(value = "SELECT trainer_color FROM trainer WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    String getTrainerColorByTrainerName(String firstName, String secondName);

    @Query(value="SELECT * FROM trainer", nativeQuery = true)
    List<TrainerEntity> getAllTrainerEntities();
}
