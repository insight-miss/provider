package com.weke.provider.vo;

import java.io.Serializable;

public class UserInfoVo implements Serializable {

    private Integer key;
    private String userName;
    private String userSex;
    private String userJob;
    private String userAddress;
    private String userAdmin;

    public UserInfoVo() {

    }

    public UserInfoVo(Integer key, String userName, String userSex, String userJob, String userAddress, String userAdmin) {
        this.key = key;
        this.userName = userName;
        this.userSex = userSex;
        this.userJob = userJob;
        this.userAddress = userAddress;
        this.userAdmin = userAdmin;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "key=" + key +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userJob='" + userJob + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userAdmin='" + userAdmin + '\'' +
                '}';
    }
}
