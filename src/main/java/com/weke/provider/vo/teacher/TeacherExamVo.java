package com.weke.provider.vo.teacher;

import java.io.Serializable;

public class TeacherExamVo implements Serializable {
    private Integer userExamId;
    private String examName;
    private String userName;
    private Integer examGrade;
    private Integer examStatues;

    public TeacherExamVo() {

    }

    public TeacherExamVo(Integer userExamId, String examName, String userName, Integer examGrade, Integer examStatues) {
        this.userExamId = userExamId;
        this.examName = examName;
        this.userName = userName;
        this.examGrade = examGrade;
        this.examStatues = examStatues;
    }

    public Integer getUserExamId() {
        return userExamId;
    }

    public void setUserExamId(Integer userExamId) {
        this.userExamId = userExamId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(Integer examGrade) {
        this.examGrade = examGrade;
    }

    public Integer getExamStatues() {
        return examStatues;
    }

    public void setExamStatues(Integer examStatues) {
        this.examStatues = examStatues;
    }

    @Override
    public String toString() {
        return "TeacherExamVo{" +
                "userExamId=" + userExamId +
                ", examName='" + examName + '\'' +
                ", userName='" + userName + '\'' +
                ", examGrade='" + examGrade + '\'' +
                ", examStatues=" + examStatues +
                '}';
    }
}
