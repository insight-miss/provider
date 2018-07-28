package com.weke.provider.vo.exam;

import java.io.Serializable;
import java.util.List;

public class ExamInfo implements Serializable {
    private Exams exam;
    private List<Questions> questions;

    public ExamInfo() {
    }

    public ExamInfo(Exams exam, List<Questions> questions) {
        this.exam = exam;
        this.questions = questions;
    }

    public Exams getExam() {
        return exam;
    }

    public void setExam(Exams exam) {
        this.exam = exam;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ExamInfo{" +
                "exam=" + exam +
                ", questions=" + questions +
                '}';
    }
}
