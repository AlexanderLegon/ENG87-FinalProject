package com.sparta.eng87.finalproject.entities;

import com.sparta.eng87.finalproject.repositories.DisciplineRepository;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "discipline", schema = "courseorganisation", catalog = "")
public class DisciplineEntity {
    private Integer discipline_id;
    private String discipline_name;
    private Integer discipline_duration;

    public DisciplineEntity(){
    }

    public DisciplineEntity(String discipline_name, Integer discipline_duration){
        this.discipline_name = discipline_name;
        this.discipline_duration = discipline_duration;
    }

    @Id
    @GeneratedValue
    @Column(name = "discipline_id")
    public Integer getDiscipline_id() {
        return discipline_id;
    }

    public void setDiscipline_id(Integer discipline_id) {
        this.discipline_id = discipline_id;
    }

    @Basic
    @Column(name = "discipline_name")
    public String getDiscipline_name() {
        return discipline_name;
    }

    public void setDiscipline_name(String discipline_name) {
        this.discipline_name = discipline_name;
    }

    @Basic
    @Column(name = "discipline_duration")
    public Integer getDiscipline_duration() {
        return discipline_duration;
    }

    public void setDiscipline_duration(Integer discipline_duration) {
        this.discipline_duration = discipline_duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineEntity that = (DisciplineEntity) o;
        return Objects.equals(discipline_id, that.discipline_id) && Objects.equals(discipline_name, that.discipline_name) && Objects.equals(discipline_duration, that.discipline_duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discipline_id, discipline_name, discipline_duration);
    }
}
