package com.weke.provider.vo;

import java.io.Serializable;

public class EmailVo implements Serializable {
    private String userName;
    private String token;

    public EmailVo() {

    }

    public EmailVo(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "EmailVo{" +
                "userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
