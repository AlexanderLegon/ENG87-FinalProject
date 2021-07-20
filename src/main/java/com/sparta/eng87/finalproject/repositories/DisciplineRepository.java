package com.sparta.eng87.finalproject.repositories;

import com.sparta.eng87.finalproject.entities.DisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineEntity,Integer> {

    @Query(value = "SELECT * FROM discipline d", nativeQuery = true)
    List<Object[]> getAllDisciplines();
}
