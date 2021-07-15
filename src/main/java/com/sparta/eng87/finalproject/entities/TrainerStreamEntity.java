package com.sparta.eng87.finalproject.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "trainer_stream", schema = "courseorganisation", catalog = "")
public class TrainerStreamEntity {
    private Integer trainer_id;
    private Integer discipline_id;

    public TrainerStreamEntity(){
    }

    public TrainerStreamEntity(Integer trainer_id, Integer discipline_id){
        this.trainer_id = trainer_id;
        this.discipline_id = discipline_id;
    }
    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id")
    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }
    @ManyToOne
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    public Integer getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Integer discipline_id) {
        this.discipline_id = discipline_id;
    }

}
