package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.CourseTrainerDatesEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTrainerDatesEntityTest {

    CourseTrainerDatesEntity courseTrainerDatesEntity;

    @BeforeEach
    void setup(){
        courseTrainerDatesEntity = new CourseTrainerDatesEntity(1,1,4,1,1);
    }

    @Test
    public void shouldReturnCrsTrnDateId(){
        Assertions.assertEquals(1, courseTrainerDatesEntity.getCourseTrainerDatesId());
    }

    @Test
    public void shouldReturnTrainerId(){
        Assertions.assertEquals(1, courseTrainerDatesEntity.getTrainerId());
    }

    @Test
    public void shouldReturnCourseId(){
        Assertions.assertEquals(4, courseTrainerDatesEntity.getCourseId());
    }

    @Test
    public void shouldReturnTrainerStarDate(){
        Assertions.assertEquals(1, courseTrainerDatesEntity.getTrainerStartDate());
    }

    @Test
    public void shouldReturnTrainerEndDate(){
        Assertions.assertEquals(1, courseTrainerDatesEntity.getTrainerEndDate());
    }
}
