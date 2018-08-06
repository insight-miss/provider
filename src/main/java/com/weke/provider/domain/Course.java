package com.weke.provider.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "weke", type = "course",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Course {
    @Id
    private Integer courseId;
    private String courseName;
    private String courseInfo;
    private String courseTime;
    private Integer coursePeople;
    private String courseDiff;
    private Integer directionId;
    private String courseKind;
    private Integer courseLevel;
    private String mustKnow;

    public Course(){

    }

    public Course(Integer courseId, String courseName, String courseInfo, String courseTime, Integer coursePeople, String courseDiff, Integer directionId, String courseKind, Integer courseLevel, String mustKnow) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseTime = courseTime;
        this.coursePeople = coursePeople;
        this.courseDiff = courseDiff;
        this.directionId = directionId;
        this.courseKind = courseKind;
        this.courseLevel = courseLevel;
        this.mustKnow = mustKnow;
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

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Integer getCoursePeople() {
        return coursePeople;
    }

    public void setCoursePeople(Integer coursePeople) {
        this.coursePeople = coursePeople;
    }

    public String getCourseDiff() {
        return courseDiff;
    }

    public void setCourseDiff(String courseDiff) {
        this.courseDiff = courseDiff;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(String courseKind) {
        this.courseKind = courseKind;
    }

    public Integer getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getMustKnow() {
        return mustKnow;
    }

    public void setMustKnow(String mustKnow) {
        this.mustKnow = mustKnow;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", coursePeople=" + coursePeople +
                ", courseDiff='" + courseDiff + '\'' +
                ", directionId=" + directionId +
                ", courseKind='" + courseKind + '\'' +
                ", courseLevel=" + courseLevel +
                ", mustKnow='" + mustKnow + '\'' +
                '}';
    }
}
