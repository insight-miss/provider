package com.weke.provider.vo;

import java.io.Serializable;

public class VideoVo implements Serializable {

    private String videoUrl;
    private String photoUrl;
    private String nickname;

    public VideoVo(){}

    public VideoVo(String videoUrl, String photoUrl, String nickname) {
        this.videoUrl = videoUrl;
        this.photoUrl = photoUrl;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "VideoVo{" +
                "videoUrl='" + videoUrl + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
