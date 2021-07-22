package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.CourseTypeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTypeEntityTests {

    CourseTypeEntity courseTypeEntity;

    @BeforeEach
    void setup() {
        courseTypeEntity = new CourseTypeEntity("Technology");
    }

    @Test
    public void shouldReturnId() {
        courseTypeEntity.setCourseTypeId(1);
        Assertions.assertEquals(1, courseTypeEntity.getCourseTypeId());
    }

    @Test
    public void shouldReturnTechnology() {
        Assertions.assertEquals("Technology", courseTypeEntity.getTypeName());
    }

    @Test
    public void shouldReturnBusiness() {
        courseTypeEntity.setTypeName("Business");
        Assertions.assertEquals("Business", courseTypeEntity.getTypeName());
    }
}
