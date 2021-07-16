package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import com.sparta.eng87.finalproject.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {
    private DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public void addDiscipline(DisciplineEntity disciplineEntity) {
        disciplineRepository.save(disciplineEntity);
    }

    public DisciplineEntity findDisciplineById(Integer id){
        return disciplineRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid Discipline ID " + id)
        );
    }


}
