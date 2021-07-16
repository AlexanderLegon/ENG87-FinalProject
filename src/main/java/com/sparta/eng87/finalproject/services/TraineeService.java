package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.TraineeEntity;
import com.sparta.eng87.finalproject.repositories.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {

    private TraineeRepository traineeRepository;

    @Autowired
    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public void addTrainee(TraineeEntity traineeEntity){
        traineeRepository.save(traineeEntity);

    }

    public TraineeEntity getTraineeById(Integer id) {
        return traineeRepository.getById(id);
    }

    public void deleteTrainee(Integer id) {
        traineeRepository.deleteById(id);
    }
}
