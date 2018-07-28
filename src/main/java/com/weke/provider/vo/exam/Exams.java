package com.weke.provider.vo.exam;

import java.io.Serializable;

public class Exams implements Serializable {

    private Integer id;
    private String examTitle;
    private String startTime;
    private String endTime;
    private String statues;
    private String grade;
    private Integer userId;

    public Exams() {
    }

    public Exams(Integer id, String examTitle, String startTime, String endTime, String statues, String grade, Integer userId) {
        this.id = id;
        this.examTitle = examTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statues = statues;
        this.grade = grade;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
                "id=" + id +
                ", examTitle='" + examTitle + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", statues='" + statues + '\'' +
                ", grade='" + grade + '\'' +
                ", userId=" + userId +
                '}';
    }
}
