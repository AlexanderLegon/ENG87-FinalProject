package com.sparta.eng87.finalproject.entitiesTest;

import com.sparta.eng87.finalproject.entities.QualityGateEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class QualityGateTest {

    QualityGateEntity qualityGateEntity;

    @BeforeEach
    void setup(){
        qualityGateEntity = new QualityGateEntity(1,"Passed",2,3,"Good","Excellent", Date.valueOf("2021-05-10"));
    }

    @Test
    public void shouldReturnQualityGateId(){
        qualityGateEntity.setQualityGateID(1);
        Assertions.assertEquals(1, qualityGateEntity.getQualityGateID());
    }

    @Test
    public void shouldReturnTraineeId(){
        Assertions.assertEquals(1, qualityGateEntity.getTraineeID());
    }

    @Test
    public void shouldReturnIsPass(){
        Assertions.assertEquals("Passed", qualityGateEntity.getPass());
    }

    @Test
    public void shouldReturnTrainer1Id(){
        Assertions.assertEquals(2, qualityGateEntity.getTrainer1ID());
    }

    @Test
    public void shouldReturnTrainer2Id(){
        Assertions.assertEquals(3, qualityGateEntity.getTrainer2ID());
    }

    @Test
    public void shouldReturnTrainerFeedback1(){
        Assertions.assertEquals("Good", qualityGateEntity.getFeedbackTrainer1());
    }

    @Test
    public void shouldReturnTrainerFeedback2(){
        Assertions.assertEquals("Excellent", qualityGateEntity.getFeedbackTrainer2());
    }

    @Test
    public void shouldReturnDate(){
        Assertions.assertEquals(Date.valueOf("2021-05-10"), qualityGateEntity.getQualityGateDate());
    }

}
