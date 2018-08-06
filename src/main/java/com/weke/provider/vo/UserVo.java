package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserVo implements Serializable {

    private String url;
    private String nickname;
    private String job;
    private String address;
    private String sex;
    @JsonProperty("info")
    private String signature;

    public UserVo() {
    }

    public UserVo(String url, String nickname, String job, String address, String sex, String signature) {
        this.url = url;
        this.nickname = nickname;
        this.job = job;
        this.address = address;
        this.sex = sex;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "url='" + url + '\'' +
                ", nickname='" + nickname + '\'' +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
