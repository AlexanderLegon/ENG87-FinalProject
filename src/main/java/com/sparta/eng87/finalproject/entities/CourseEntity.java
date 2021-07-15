package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "course", schema="courseorganisation")
@SequenceGenerator(name="sequenceCourse", initialValue=1, allocationSize = 1)
public class CourseEntity implements Serializable {

    private Integer courseId;
    private String courseName;
    private Integer disciplineId;
    private Integer trainerId;
    private Integer typeId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity locationEntity;

    private Date startDate;

    public CourseEntity(String courseName, Integer disciplineId, Integer trainerId, Integer typeId, Date startDate) {
        this.courseName = courseName;
        this.disciplineId = disciplineId;
        this.trainerId = trainerId;
        this.typeId = typeId;
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
    @Column(name="start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start) {
        this.startDate = start;
    }


}
