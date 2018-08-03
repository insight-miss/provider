package com.weke.provider.vo.exam;

import com.weke.provider.mongodb.Question;

import java.util.List;

public class UserExamVo {
    private Integer testId;
    private String userName;
    private List<Question> questions;

    public UserExamVo() {
    }

    public UserExamVo(Integer testId, String userName, List<Question> questions) {
        this.testId = testId;
        this.userName = userName;
        this.questions = questions;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "UserExamVo{" +
                "testId=" + testId +
                ", userName='" + userName + '\'' +
                ", questions=" + questions +
                '}';
    }
}
