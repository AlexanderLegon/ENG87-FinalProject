package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.QualityGateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualityGateRepository extends JpaRepository<QualityGateEntity,Integer>{

    @Query(value = "SELECT * FROM quality_gate ORDER BY quality_gate_date DESC", nativeQuery = true)
    List<QualityGateEntity> getAllQualityGates();
}
