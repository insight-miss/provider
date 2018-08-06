package com.weke.provider.domain.ESdomain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName = "weke", type = "course")
public class ESCourse implements Serializable {

    @Id
    private Integer courseId;
    @Field(searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String courseName;
    @Field(searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String courseInfo;
    @Field(searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String courseDiff;
    @Field(searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String courseKind;
    @Field(searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String url;

    public ESCourse() {}

    public ESCourse(Integer courseId, String courseName, String courseInfo, String courseDiff, String courseKind,String url) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseDiff = courseDiff;
        this.courseKind = courseKind;
        this.url = url;
    }


    @Override
    public String toString() {
        return "ESCourse{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                ", courseDiff='" + courseDiff + '\'' +
                ", courseKind='" + courseKind + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
