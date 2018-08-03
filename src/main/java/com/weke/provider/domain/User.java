package com.weke.provider.domain;

public class User {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPhoto;
    private String userSex;
    private String userJob;
    private String userRoot;
    private String userEmail;
    private String userAddress;
    private String userSignature;
    private String userPhone;

    public User() {
    }

    public User(Integer userId, String userName, String userPassword, String userPhoto, String userSex, String userJob, String userRoot, String userEmail, String userAddress, String userSignature, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhoto = userPhoto;
        this.userSex = userSex;
        this.userJob = userJob;
        this.userRoot = userRoot;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userSignature = userSignature;
        this.userPhone = userPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
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

    public String getUserRoot() {
        return userRoot;
    }

    public void setUserRoot(String userRoot) {
        this.userRoot = userRoot;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userJob='" + userJob + '\'' +
                ", userRoot='" + userRoot + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
