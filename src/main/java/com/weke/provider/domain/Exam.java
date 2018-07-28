package com.weke.provider.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Exam {

    private Integer examId;
    private String examName;
    private String startTime;
    private String endTime;
    private String statues;
    private String examGrade;
    private Integer userId;

    public Exam() {
    }

    public Exam(String examName, String startTime, String endTime, String statues, String examGrade, Integer userId) {
        this.examName = examName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statues = statues;
        this.examGrade = examGrade;
        this.userId = userId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

    public String getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(String examGrade) {
        this.examGrade = examGrade;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", statues='" + statues + '\'' +
                ", examGrade='" + examGrade + '\'' +
                ", userId=" + userId +
                '}';
    }
}
