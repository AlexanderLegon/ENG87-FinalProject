package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity, Integer> {

}
