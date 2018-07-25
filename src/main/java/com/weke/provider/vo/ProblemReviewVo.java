package com.weke.provider.vo;

import java.io.Serializable;

public class ProblemReviewVo implements Serializable {

    private String kind;
    private Integer num;
    private String time;
    private String photo;
    private String comment;
    private String browse;
    private String title;
    private Integer userId;

    public ProblemReviewVo() {
    }

    public ProblemReviewVo(String kind, Integer num, String time, String photo, String comment, String browse, String title, Integer userId) {
        this.kind = kind;
        this.num = num;
        this.time = time;
        this.photo = photo;
        this.comment = comment;
        this.browse = browse;
        this.title = title;
        this.userId = userId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBrowse() {
        return browse;
    }

    public void setBrowse(String browse) {
        this.browse = browse;
    }

    @Override
    public String toString() {
        return "ProblemReviewVo{" +
                "kind='" + kind + '\'' +
                ", num=" + num +
                ", time='" + time + '\'' +
                ", photo='" + photo + '\'' +
                ", comment='" + comment + '\'' +
                ", browse='" + browse + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}
