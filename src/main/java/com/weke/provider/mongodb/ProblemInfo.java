package com.weke.provider.mongodb;

import com.weke.provider.vo.exam.Option;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class ProblemInfo implements Serializable {

    @Id
    private String userId;
    private Integer type;
    private Integer questionNumber;
    private String problem;
    private List<Option> options;
    private String userAnswer;
    private List<String> answer;
    private Integer status;
    private Integer grade;
    private Integer testId;

    public ProblemInfo() {
    }

    public ProblemInfo(String userId, Integer type, Integer questionNumber, String problem, List<Option> options, String userAnswer, List<String> answer, Integer status, Integer grade, Integer testId) {
        this.userId = userId;
        this.type = type;
        this.questionNumber = questionNumber;
        this.problem = problem;
        this.options = options;
        this.userAnswer = userAnswer;
        this.answer = answer;
        this.status = status;
        this.grade = grade;
        this.testId = testId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
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

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "ProblemInfo{" +
                "userId='" + userId + '\'' +
                ", type=" + type +
                ", questionNumber=" + questionNumber +
                ", problem='" + problem + '\'' +
                ", options=" + options +
                ", userAnswer='" + userAnswer + '\'' +
                ", answer=" + answer +
                ", status=" + status +
                ", grade=" + grade +
                ", testId=" + testId +
                '}';
    }
}
