package com.weke.provider.vo.aliPay;

import java.io.Serializable;

public class AliPayVo implements Serializable {

    private String orderNo;
    private String qrCode;
    private String totleFee;
    private String subject;

    public AliPayVo() {}

    public AliPayVo(String orderNo, String qrCode, String totleFee, String subject) {
        this.orderNo = orderNo;
        this.qrCode = qrCode;
        this.totleFee = totleFee;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "AliPayVo{" +
                "orderNo='" + orderNo + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", totleFee='" + totleFee + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getTotleFee() {
        return totleFee;
    }

    public void setTotleFee(String totleFee) {
        this.totleFee = totleFee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
