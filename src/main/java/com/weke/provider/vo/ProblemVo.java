package com.weke.provider.vo;

import java.io.Serializable;

public class ProblemVo implements Serializable {
    private String courseId;
    private String title;
    private String info;

    public ProblemVo() {
    }

    public ProblemVo(String courseId, String title, String info) {
        this.courseId = courseId;
        this.title = title;
        this.info = info;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ProblemVo{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
