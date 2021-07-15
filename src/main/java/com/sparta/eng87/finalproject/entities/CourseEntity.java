package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "course", schema="courseorganisation")
public class CourseEntity {

    private Integer courseId;
    private String courseName;
    private Integer disciplineId;
    private Integer trainerId;
    private Integer typeId;
    private Integer locationId;
    private Date startDate;

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name="course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name="discipline_id")
    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer streamId) {
        this.disciplineId = streamId;
    }

    @Basic
    @Column(name="trainer_id")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name="type_id")
    public Integer getTypeId() {
        return typeId;
    }


    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name="location_id")
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name="start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start) {
        this.startDate = start;
    }


}
