package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.TraineeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TraineeEntityTests {

    TraineeEntity traineeEntity;

    @BeforeEach
    void setup() {
        traineeEntity = new TraineeEntity("Alex", "Chang", 1);
    }

    @Test
    public void shouldReturnId() {
        traineeEntity.setTraineeId(1);
        Assertions.assertEquals(1, traineeEntity.getTraineeId());
    }

    @Test
    public void shouldReturnAlex() {
        Assertions.assertEquals("Alex", traineeEntity.getFirstName());
    }

    @Test
    public void shouldReturnRichard() {
        traineeEntity.setFirstName("Richard");
        Assertions.assertEquals("Richard", traineeEntity.getFirstName());
    }

    @Test
    public void shouldReturnChang() {
        Assertions.assertEquals("Chang", traineeEntity.getLastName());
    }

    @Test
    public void shouldReturnGuerney() {
        traineeEntity.setLastName("Guerney");
        Assertions.assertEquals("Guerney", traineeEntity.getLastName());
    }

    @Test
    public void shouldReturn1() {
        Assertions.assertEquals(1, traineeEntity.getCourseId());
    }

    @Test
    public void shouldReturn2() {
        traineeEntity.setCourseId(2);
        Assertions.assertEquals(2, traineeEntity.getCourseId());
    }
}
