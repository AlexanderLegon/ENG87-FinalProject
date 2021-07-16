package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Integer> {
    @Query(value="SELECT * FROM trainer ORDER BY trainer_id", nativeQuery = true)
    List<TrainerEntity> getAllTrainers();
}
