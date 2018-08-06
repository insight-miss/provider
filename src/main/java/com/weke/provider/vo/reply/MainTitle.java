package com.weke.provider.vo.reply;

import java.io.Serializable;

public class MainTitle implements Serializable {

    private String commentId;
    private String nickname;
    private String title;
    private String content;
    private String time;
    private String num;// 回答数量
    private String browser;// 浏览
    private String photo;

    public MainTitle() {}

    public MainTitle(String commentId, String nickname, String title, String content, String time, String num, String browser,String photo) {
        this.commentId = commentId;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.time = time;
        this.num = num;
        this.browser = browser;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "MainTitle{" +
                "commentId='" + commentId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", num='" + num + '\'' +
                ", browser='" + browser + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
