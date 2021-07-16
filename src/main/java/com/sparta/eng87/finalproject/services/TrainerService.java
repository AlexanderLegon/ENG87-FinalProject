package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import com.sparta.eng87.finalproject.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    public void save(TrainerEntity trainerEntity){
        trainerRepository.save(trainerEntity);
    }

    public void addTrainer(TrainerEntity trainerEntity){
        trainerRepository.save(trainerEntity);
    }
}
