package com.sparta.eng87.finalproject.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainer_stream", schema = "courseorganisation", catalog = "")
@IdClass(TrainerDisciplinePKEntity.class)
public class TrainerStreamEntity {

    @Id
    @OneToMany
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id")
    private List<TraineeEntity> trainer_id;

    @OneToMany
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    private List<DisciplineEntity> discipline_id;

    public TrainerStreamEntity(){
    }

    public TrainerStreamEntity(List<TraineeEntity> trainer_id, List<DisciplineEntity> discipline_id){
        this.trainer_id = trainer_id;
        this.discipline_id = discipline_id;
    }


    public List<TraineeEntity> getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(List<TraineeEntity> trainer_id) {
        this.trainer_id = trainer_id;
    }

    public List<DisciplineEntity> getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(List<DisciplineEntity> discipline_id) {
        this.discipline_id = discipline_id;
    }
}
