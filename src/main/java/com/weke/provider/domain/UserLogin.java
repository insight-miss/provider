package com.weke.provider.domain;

public class UserLogin {

    private Integer loginId;
    private String loginCity;
    private String loginTime;
    private String loginIp;
    private String loginEquipment;
    private String loginType;
    private String userName;

    public UserLogin() {

    }

    public UserLogin(Integer loginId, String loginCity, String loginTime, String loginIp, String loginEquipment, String loginType, String userName) {
        this.loginId = loginId;
        this.loginCity = loginCity;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.loginEquipment = loginEquipment;
        this.loginType = loginType;
        this.userName = userName;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginCity() {
        return loginCity;
    }

    public void setLoginCity(String loginCity) {
        this.loginCity = loginCity;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginEquipment() {
        return loginEquipment;
    }

    public void setLoginEquipment(String loginEquipment) {
        this.loginEquipment = loginEquipment;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "loginId=" + loginId +
                ", loginCity='" + loginCity + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginEquipment='" + loginEquipment + '\'' +
                ", loginType='" + loginType + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
