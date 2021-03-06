package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import com.sparta.eng87.finalproject.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void save(TrainerEntity trainerEntity) {
        trainerRepository.save(trainerEntity);
    }

    public void addTrainer(TrainerEntity trainerEntity) {
        trainerRepository.save(trainerEntity);
    }

    public Object findTrainerById(Integer id) {
        return trainerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid trainer ID: " + id)
        );
    }

    public List<Object> getAllTrainers() {
        return trainerRepository.getAllTrainers();
    }

    public void deleteTrainer(Integer id) {
        trainerRepository.deleteById(id);
    }

    public List<String> getListOfTrainerColor(List<String> trainerNames) {
        List<String> colors = new ArrayList<>();
        for (String trainer : trainerNames) {
            String[] trainerName = trainer.split(" ");
            colors.add(trainerRepository.getTrainerColorByTrainerName(trainerName[0], trainerName[1]));
        }
        return colors;
    }

    public List<TrainerEntity> getAllTrainerEntities() {
        return trainerRepository.getAllTrainerEntities();
    }
}
