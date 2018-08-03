package com.weke.provider.mongodb;

import java.io.Serializable;
import java.util.List;

public class ExamExport implements Serializable {
    private String examName;
    private Integer sumGrade;
    private Integer correctNumber;
    private Integer totalNumber;
    private Integer choiceScore;
    private Integer blankScore;
    private Integer answerScore;
    private List<Echar> eCharts;

    public ExamExport() {

    }

    public ExamExport(String examName, Integer sumGrade, Integer correctNumber, Integer totalNumber, Integer choiceScore, Integer blankScore, Integer answerScore, List<Echar> eCharts) {
        this.examName = examName;
        this.sumGrade = sumGrade;
        this.correctNumber = correctNumber;
        this.totalNumber = totalNumber;
        this.choiceScore = choiceScore;
        this.blankScore = blankScore;
        this.answerScore = answerScore;
        this.eCharts = eCharts;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getSumGrade() {
        return sumGrade;
    }

    public void setSumGrade(Integer sumGrade) {
        this.sumGrade = sumGrade;
    }

    public Integer getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(Integer correctNumber) {
        this.correctNumber = correctNumber;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(Integer choiceScore) {
        this.choiceScore = choiceScore;
    }

    public Integer getBlankScore() {
        return blankScore;
    }

    public void setBlankScore(Integer blankScore) {
        this.blankScore = blankScore;
    }

    public Integer getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(Integer answerScore) {
        this.answerScore = answerScore;
    }

    public List<Echar> geteCharts() {
        return eCharts;
    }

    public void seteCharts(List<Echar> eCharts) {
        this.eCharts = eCharts;
    }

    @Override
    public String toString() {
        return "ExamExport{" +
                "examName='" + examName + '\'' +
                ", sumGrade=" + sumGrade +
                ", correctNumber=" + correctNumber +
                ", totalNumber=" + totalNumber +
                ", choiceScore=" + choiceScore +
                ", blankScore=" + blankScore +
                ", answerScore=" + answerScore +
                ", eCharts=" + eCharts +
                '}';
    }
}
