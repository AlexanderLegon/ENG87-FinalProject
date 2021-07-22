package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "course", schema="courseorganisation")
@SequenceGenerator(name="sequenceCourse", initialValue=1, allocationSize = 1)
public class CourseEntity {

    private Integer courseId;
    private String courseName;
    private Integer disciplineId;
    private Integer trainerId;
    private Integer typeId;
    private Integer locationId;
    private Date startDate;

    public CourseEntity(String courseName, Integer disciplineId, Integer trainerId, Integer typeId, Integer locationId, Date startDate) {
        this.courseName = courseName;
        this.disciplineId = disciplineId;
        this.trainerId = trainerId;
        this.typeId = typeId;
        this.locationId = locationId;
        this.startDate = startDate;
    }

    public CourseEntity() {
    }

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCourse")
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
