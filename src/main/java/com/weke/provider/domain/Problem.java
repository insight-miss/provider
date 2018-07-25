package com.weke.provider.domain;

public class Problem {

    private Integer problemId;
    private Integer answerNum;
    private Integer userId;
    private String problemInfo;
    private Integer viewNumber;
    private String problemTitle;
    private String courseId;

    public Problem() {
    }

    public Problem(Integer problemId, Integer answerNum, Integer userId, String problemInfo, Integer viewNumber, String problemTitle, String courseId) {
        this.problemId = problemId;
        this.answerNum = answerNum;
        this.userId = userId;
        this.problemInfo = problemInfo;
        this.viewNumber = viewNumber;
        this.problemTitle = problemTitle;
        this.courseId = courseId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProblemInfo() {
        return problemInfo;
    }

    public void setProblemInfo(String problemInfo) {
        this.problemInfo = problemInfo;
    }

    public Integer getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + problemId +
                ", answerNum=" + answerNum +
                ", userId=" + userId +
                ", problemInfo='" + problemInfo + '\'' +
                ", viewNumber=" + viewNumber +
                ", problemTitle='" + problemTitle + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
