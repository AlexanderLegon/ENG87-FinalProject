package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.TrainerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrainerEntityTest {

    TrainerEntity trainerEntity;

    @BeforeEach
    void setup(){
        trainerEntity = new TrainerEntity("Karim", "Wohler");
    }

    @Test
    public void shouldReturnId(){
        trainerEntity.setTrainerId(1);
        Assertions.assertEquals(1, trainerEntity.getTrainerId());
    }

    @Test
    public void shouldReturnFirstName(){
        Assertions.assertEquals("Karim", trainerEntity.getFirstName());
    }

    @Test
    public void shouldReturnLastName(){
        Assertions.assertEquals("Wohler", trainerEntity.getLastName());
    }
}
