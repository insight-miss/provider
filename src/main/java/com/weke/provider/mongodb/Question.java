package com.weke.provider.mongodb;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

    private Integer type;

    private Integer questionNumber;

    private String problem;

    private List<Options> options;

    private String userAnswer;

    private String answer;

    private Integer status;

    private Integer grade;

    public Question() {
    }

    public Question(Integer type, Integer questionNumber, String problem, List<Options> options, String userAnswer, String answer, Integer status, Integer grade) {
        this.type = type;
        this.questionNumber = questionNumber;
        this.problem = problem;
        this.options = options;
        this.userAnswer = userAnswer;
        this.answer = answer;
        this.status = status;
        this.grade = grade;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Question{" +
                "type=" + type +
                ", questionNumber=" + questionNumber +
                ", problem='" + problem + '\'' +
                ", options=" + options +
                ", userAnswer='" + userAnswer + '\'' +
                ", answer='" + answer + '\'' +
                ", status=" + status +
                ", grade=" + grade +
                '}';
    }
}
