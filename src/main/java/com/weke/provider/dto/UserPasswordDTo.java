package com.weke.provider.dto;

import java.io.Serializable;

public class UserPasswordDTo implements Serializable {
    private String userName;
    private String password;
    private String currentPassword;

    public UserPasswordDTo() {

    }

    public UserPasswordDTo(String userName, String password, String currentPassword) {
        this.userName = userName;
        this.password = password;
        this.currentPassword = currentPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    @Override
    public String toString() {
        return "UserPasswordDTo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                '}';
    }
}
