package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.QualityGateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityGateRepository extends JpaRepository<QualityGateEntity,Integer>{
}
