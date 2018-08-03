package com.weke.provider.domain;

public class UserExam {
    private Integer id;
    private String userName;
    private Integer testId;
    private Integer grade;
    private Integer correctRate;
    private Integer statues;
    private Integer correctNumber;

    public UserExam() {

    }

    public UserExam(Integer id, String userName, Integer testId, Integer grade, Integer correctRate, Integer statues, Integer correctNumber) {
        this.id = id;
        this.userName = userName;
        this.testId = testId;
        this.grade = grade;
        this.correctRate = correctRate;
        this.statues = statues;
        this.correctNumber = correctNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(Integer correctRate) {
        this.correctRate = correctRate;
    }

    public Integer getStatues() {
        return statues;
    }

    public void setStatues(Integer statues) {
        this.statues = statues;
    }

    public Integer getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(Integer correctNumber) {
        this.correctNumber = correctNumber;
    }

    @Override
    public String toString() {
        return "UserExam{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", testId=" + testId +
                ", grade=" + grade +
                ", correctRate=" + correctRate +
                ", statues=" + statues +
                ", correctNumber=" + correctNumber +
                '}';
    }
}
