package com.weke.provider.mongodb;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class UserExamInfo implements Serializable {
    @Id
    private Integer userExamId;
    private ExamExport examExport;
    private List<Question> questions;

    public UserExamInfo() {

    }

    public UserExamInfo(Integer userExamId, ExamExport examExport, List<Question> questions) {
        this.userExamId = userExamId;
        this.examExport = examExport;
        this.questions = questions;
    }

    public Integer getUserExamId() {
        return userExamId;
    }

    public void setUserExamId(Integer userExamId) {
        this.userExamId = userExamId;
    }

    public ExamExport getExamExport() {
        return examExport;
    }

    public void setExamExport(ExamExport examExport) {
        this.examExport = examExport;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "UserExamInfo{" +
                "userExamId=" + userExamId +
                ", examExport=" + examExport +
                ", questions=" + questions +
                '}';
    }
}
