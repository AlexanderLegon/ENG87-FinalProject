package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;

@Entity
@Table(name= "course_type", schema = "courseorganisation")
@SequenceGenerator(name="sequenceCourseType", initialValue=1, allocationSize = 1)
public class CourseTypeEntity {


    private Integer courseTypeId;
    private String typeName;

    public CourseTypeEntity(String typeName) {
        this.typeName = typeName;
    }

    public CourseTypeEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCourseType")
    @Column(name ="course_type_id")
    public Integer getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
