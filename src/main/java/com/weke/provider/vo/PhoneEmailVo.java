package com.weke.provider.vo;

import java.io.Serializable;

public class PhoneEmailVo implements Serializable {

    private String userPhone;
    private String userEmail;

    public PhoneEmailVo() {

    }

    public PhoneEmailVo(String userPhone, String userEmail) {
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "PhoneEmailVo{" +
                "userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
