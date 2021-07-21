package com.sparta.eng87.finalproject.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(schema = "courseorganisation", name="quality_gate")
public class QualityGateEntity {

    private Integer qualityGateID;
    private Integer traineeID;
    private String isPass;
    private Integer trainer1ID;
    private Integer trainer2ID;
    private String feedbackTrainer1;
    private String feedbackTrainer2;
    private Date qualityGateDate;

    public QualityGateEntity(Integer traineeID, String isPass, Integer trainer1ID, Integer trainer2ID, String feedbackTrainer1, String feedbackTrainer2, Date qualityGateDate) {
        this.traineeID = traineeID;
        this.isPass = isPass;
        this.trainer1ID = trainer1ID;
        this.trainer2ID = trainer2ID;
        this.feedbackTrainer1 = feedbackTrainer1;
        this.feedbackTrainer2 = feedbackTrainer2;
        this.qualityGateDate = qualityGateDate;
    }

    public QualityGateEntity() {
    }

    @Id
    @GeneratedValue
    @Column(name="quality_gate_id")
    public Integer getQualityGateID() {
        return qualityGateID;
    }

    public void setQualityGateID(Integer qualityGateID) {
        this.qualityGateID = qualityGateID;
    }

    @Basic
    @Column(name="trainee_id")
    public Integer getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(Integer traineeID) {
        this.traineeID = traineeID;
    }

    @Basic
    @Column(name = "quality_gate_status")
    public String getPass() {
        return isPass;
    }

    public void setPass(String pass) {
        isPass = pass;
    }

    @Basic
    @Column(name="trainer_id_1")
    public Integer getTrainer1ID() {
        return trainer1ID;
    }

    public void setTrainer1ID(Integer trainer1ID) {
        this.trainer1ID = trainer1ID;
    }

    @Basic
    @Column(name="trainer_id_2")
    public Integer getTrainer2ID() {
        return trainer2ID;
    }

    public void setTrainer2ID(Integer trainer2ID) {
        this.trainer2ID = trainer2ID;
    }
    @Basic
    @Column(name="trainer_feedback_1")
    public String getFeedbackTrainer1() {
        return feedbackTrainer1;
    }

    public void setFeedbackTrainer1(String feedbackTrainer1) {
        this.feedbackTrainer1 = feedbackTrainer1;
    }

    @Basic
    @Column(name="trainer_feedback_2")
    public String getFeedbackTrainer2() {
        return feedbackTrainer2;
    }

    public void setFeedbackTrainer2(String feedbackTrainer2) {
        this.feedbackTrainer2 = feedbackTrainer2;
    }

    @Basic
    @Column(name = "quality_gate_date")
    public Date getQualityGateDate() {
        return qualityGateDate;
    }

    public void setQualityGateDate(Date qualityGateDate) {
        this.qualityGateDate = qualityGateDate;
    }
}
