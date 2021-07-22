package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.CourseEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;


public class CourseEntityTest {

    CourseEntity courseEntity;

    @BeforeEach
    void setup(){
        courseEntity = new CourseEntity("Engineering 87", 1 ,1 , 2 ,1, Date.valueOf("2021-05-04"));
    }

    @Test
    public void shouldReturnCourseId(){
        courseEntity.setCourseId(1);
        Assertions.assertEquals(1, courseEntity.getCourseId());
    }

    @Test
    public void shouldReturnCourseName(){
        Assertions.assertEquals("Engineering 87", courseEntity.getCourseName());
    }

    @Test
    public void shouldReturnDisciplineId(){
        Assertions.assertEquals(1, courseEntity.getDisciplineId());
    }

    @Test
    public void shouldReturnTrainerId(){
        Assertions.assertEquals(1, courseEntity.getTrainerId());
    }

    @Test
    public void shouldReturnTypeId(){
        Assertions.assertEquals(2, courseEntity.getTypeId());
    }

    @Test
    public void shouldReturnLocationId(){
        Assertions.assertEquals(1, courseEntity.getLocationId());
    }

    @Test
    public void shouldReturnDate(){
        Assertions.assertEquals(Date.valueOf("2021-05-04"), courseEntity.getStartDate());
    }

}
