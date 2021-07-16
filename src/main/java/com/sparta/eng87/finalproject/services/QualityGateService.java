package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.QualityGateEntity;
import com.sparta.eng87.finalproject.repositories.QualityGateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualityGateService {

    private QualityGateRepository qualityGateRepository;

    @Autowired
    public QualityGateService(QualityGateRepository qualityGateRepository) {
        this.qualityGateRepository = qualityGateRepository;
    }

    public void save(QualityGateEntity qualityGate){
        qualityGateRepository.save(qualityGate);
    }
}
