package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CourseVo implements Serializable {

    @JsonProperty("info")
    private String courseName;

    @JsonProperty("kind")
    private String courseKind;

    @JsonProperty("level")
    private String courseDiff;

    @JsonProperty("people")
    private Integer coursePeople;

    @JsonProperty("star")
    private Integer courseLevel;

    public CourseVo() {
    }

    public CourseVo(String courseName, String courseKind, String courseDiff, Integer coursePeople, Integer courseLevel) {
        this.courseName = courseName;
        this.courseKind = courseKind;
        this.courseDiff = courseDiff;
        this.coursePeople = coursePeople;
        this.courseLevel = courseLevel;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(String courseKind) {
        this.courseKind = courseKind;
    }

    public String getCourseDiff() {
        return courseDiff;
    }

    public void setCourseDiff(String courseDiff) {
        this.courseDiff = courseDiff;
    }

    public Integer getCoursePeople() {
        return coursePeople;
    }

    public void setCoursePeople(Integer coursePeople) {
        this.coursePeople = coursePeople;
    }

    public Integer getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }
}
