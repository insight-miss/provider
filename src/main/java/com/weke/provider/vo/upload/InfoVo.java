package com.weke.provider.vo.upload;

import java.io.Serializable;

public class InfoVo implements Serializable {
    private String courseName;
    private String courseInfo;
    private String courseDiff;
    private String courseKind;
    private String courseLevel;

    public InfoVo() {}

    public InfoVo(String courseName, String courseInfo, String courseDiff, String courseKind, String courseLevel) {
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseDiff = courseDiff;
        this.courseKind = courseKind;
        this.courseLevel = courseLevel;
    }

    @Override
    public String toString() {
        return "Info{" +
                "courseName='" + courseName + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                ", courseDiff='" + courseDiff + '\'' +
                ", courseKind='" + courseKind + '\'' +
                ", courseLevel='" + courseLevel + '\'' +
                '}';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getCourseDiff() {
        return courseDiff;
    }

    public void setCourseDiff(String courseDiff) {
        this.courseDiff = courseDiff;
    }

    public String getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(String courseKind) {
        this.courseKind = courseKind;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }
}
