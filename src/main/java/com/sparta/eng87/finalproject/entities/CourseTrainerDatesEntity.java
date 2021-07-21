package com.sparta.eng87.finalproject.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_trainer_dates", schema="courseorganisation")
@SequenceGenerator(name="sequenceCourseTrainer", initialValue=1, allocationSize = 1)
public class CourseTrainerDatesEntity {

    private Integer courseTrainerDatesId;
    private Integer trainerId;
    private Integer courseId;
    private Date trainerStartDate;
    private Date trainerEndDate;


    public CourseTrainerDatesEntity() {
    }

    public CourseTrainerDatesEntity(Integer courseTrainerDatesId, Integer trainerId, Integer courseId, Date trainerStartDate, Date trainerEndDate) {
        this.courseTrainerDatesId = courseTrainerDatesId;
        this.trainerId = trainerId;
        this.courseId = courseId;
        this.trainerStartDate = trainerStartDate;
        this.trainerEndDate = trainerEndDate;
    }

    @Id
    @Column(name = "course_trainer_dates_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCourseTrainer")
    public Integer getCourseTrainerDatesId() {
        return courseTrainerDatesId;
    }

    public void setCourseTrainerDatesId(Integer courseTrainerDatesId) {
        this.courseTrainerDatesId = courseTrainerDatesId;
    }


    @Basic
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    @Basic
    @Column(name = "trainer_id")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }


    @Basic
    @Column(name = "trainer_start_date")
    public Date getTrainerStartDate() {
        return trainerStartDate;
    }

    public void setTrainerStartDate(Date trainerStartDate) {
        this.trainerStartDate = trainerStartDate;
    }


    @Basic
    @Column(name = "trainer_end_date")
    public Date getTrainerEndDate() {
        return trainerEndDate;
    }

    public void setTrainerEndDate(Date trainerEndDate) {
        this.trainerEndDate = trainerEndDate;
    }
}
