package com.weke.provider.mongodb;

import com.weke.provider.vo.exam.Exams;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class TestInfo implements Serializable {
    @Id
    private Integer testId;

    private Exams exam;

    private List<Question> questions;

    public TestInfo() {
    }

    public TestInfo(Integer testId, Exams exam, List<Question> questions) {
        this.testId = testId;
        this.exam = exam;
        this.questions = questions;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Exams getExam() {
        return exam;
    }

    public void setExam(Exams exam) {
        this.exam = exam;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "TestInfo{" +
                "testId=" + testId +
                ", exam=" + exam +
                ", questions=" + questions +
                '}';
    }
}
