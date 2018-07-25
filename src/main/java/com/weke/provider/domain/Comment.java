package com.weke.provider.domain;

public class Comment {
    private Integer commentId;
    private Integer praiseNum;
    private String commentInfo;
    private Integer userId;
    private String courseId;

    public Comment() {

    }

    public Comment(Integer commentId, Integer praiseNum, String commentInfo, Integer userId, String courseId) {
        this.commentId = commentId;
        this.praiseNum = praiseNum;
        this.commentInfo = commentInfo;
        this.userId = userId;
        this.courseId = courseId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", praiseNum=" + praiseNum +
                ", commentInfo='" + commentInfo + '\'' +
                ", userId=" + userId +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
