package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "trainer", schema = "courseorganisation", catalog = "")
@SequenceGenerator(name="sequenceTrainer", initialValue=1, allocationSize = 1)
public class TrainerEntity {
    private Integer trainerId;
    private String firstName;
    private String lastName;
    private String color;

    public TrainerEntity(String firstName, String lastName, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.color = color;
    }

    public TrainerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TrainerEntity() {
    }

    @Id
    @Column(name = "trainer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceTrainer")
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

    @Basic
    @Column(name = "trainerColor")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

