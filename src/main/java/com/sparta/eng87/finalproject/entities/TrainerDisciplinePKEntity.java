package com.sparta.eng87.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TrainerDisciplinePKEntity implements Serializable {

    private Integer discipline_id;
    private Integer trainer_id;

    @Id
    @Column(name = "discipline_id")
    public Integer getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Integer discipline_id) {
        this.discipline_id = discipline_id;
    }

    @Id
    @Column(name = "trainer_id")
    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }
}
