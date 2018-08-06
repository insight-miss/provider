package com.weke.provider.vo.reply;

import java.io.Serializable;
import java.util.List;

public class ReplysVo implements Serializable {

    private String replyId;
    private String nickname;// 回复者
    private String photo;
    private String info;
    private String time;
    private String like;
    private List<DetailVo> details;

    public ReplysVo() {}

    public ReplysVo(String replyId, String nickname, String photo, String info, String time, String like, List<DetailVo> details) {
        this.replyId = replyId;
        this.nickname = nickname;
        this.photo = photo;
        this.info = info;
        this.time = time;
        this.like = like;
        this.details = details;
    }

    @Override
    public String toString() {
        return "ReplysVo{" +
                "replyId='" + replyId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", photo='" + photo + '\'' +
                ", info='" + info + '\'' +
                ", time='" + time + '\'' +
                ", like='" + like + '\'' +
                ", details=" + details +
                '}';
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public List<DetailVo> getDetails() {
        return details;
    }

    public void setDetails(List<DetailVo> details) {
        this.details = details;
    }
}
