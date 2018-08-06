package com.weke.provider.vo.reply;

public class DetailVo {
    private String nickname;
    private String sb;// 被回复者
    private String time;
    private String photo;
    private String info;

    public DetailVo() {}

    public DetailVo(String nickname, String sb, String time, String photo, String info) {
        this.nickname = nickname;
        this.sb = sb;
        this.time = time;
        this.photo = photo;
        this.info = info;
    }

    @Override
    public String toString() {
        return "DetilVo{" +
                "nickname='" + nickname + '\'' +
                ", sb='" + sb + '\'' +
                ", time='" + time + '\'' +
                ", photo='" + photo + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
