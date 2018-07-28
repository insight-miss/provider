package com.weke.provider.vo.exam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Questions implements Serializable {

    @JsonProperty("_type")
    private Integer type;

    @JsonProperty("_questionNumber")
    private Integer questionNumber;

    @JsonProperty("_problem")
    private String problem;

    @JsonProperty("_options")
    private List<Option> options;

    @JsonProperty("_userAnswer")
    private String userAnswer;

    @JsonProperty("_answer")
    private String answer;

    @JsonProperty("_status")
    private Integer status;

    @JsonProperty("_grade")
    private Integer grade;

    public Questions() {
    }

    public Questions(Integer type, Integer questionNumber, String problem, List<Option> options, String userAnswer, String answer, Integer status, Integer grade) {
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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
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
        return "Questions{" +
                "type=" + type +
                ", questionNumber=" + questionNumber +
                ", problem='" + problem + '\'' +
                ", options=" + options +
                ", userAnswer='" + userAnswer + '\'' +
                ", answer=" + answer +
                ", status=" + status +
                ", grade=" + grade +
                '}';
    }
}
