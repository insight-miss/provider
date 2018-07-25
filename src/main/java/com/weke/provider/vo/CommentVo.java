package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CommentVo implements Serializable {

    private String courseName;

    private String info;

    public CommentVo() {
    }

    public CommentVo(String courseName, String info) {
        this.courseName = courseName;
        this.info = info;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "courseName='" + courseName + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
