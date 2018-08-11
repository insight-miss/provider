package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weke.provider.domain.UserLogin;

import java.io.Serializable;

public class UserLoginInfoVo implements Serializable {

    @JsonProperty("address")
    private String loginCity;

    @JsonProperty("time")
    private String loginTime;

    @JsonProperty("ip")
    private String loginIp;

    @JsonProperty("tool")
    private String loginEquipment;

    @JsonProperty("kind")
    private String loginType;

    public UserLoginInfoVo() {

    }

    public UserLoginInfoVo(String loginCity, String loginTime, String loginIp, String loginEquipment, String loginType) {
        this.loginCity = loginCity;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.loginEquipment = loginEquipment;
        this.loginType = loginType;
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

    @Override
    public String toString() {
        return "UserLoginInfoVo{" +
                "loginCity='" + loginCity + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginEquipment='" + loginEquipment + '\'' +
                ", loginType='" + loginType + '\'' +
                '}';
    }
}
