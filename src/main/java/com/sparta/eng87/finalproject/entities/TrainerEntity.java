package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "trainer", schema = "courseorganisation", catalog = "")
public class TrainerEntity {
    private Integer trainerId;
    private String firstName;
    private String lastName;

    @Id
    @Column(name = "trainer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getTrainerId(){
        return trainerId;
    }

    public void setTrainerId(Integer trainerId){
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
