package com.weke.provider.vo.recommend;

import java.io.Serializable;

public class Id implements Serializable {

    private Integer adId;
    private Integer allId;

    public Id() {}

    public Id(Integer adId, Integer allId) {
        this.adId = adId;
        this.allId = allId;
    }

    @Override
    public String toString() {
        return "Id{" +
                "adId=" + adId +
                ", allId=" + allId +
                '}';
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getAllId() {
        return allId;
    }

    public void setAllId(Integer allId) {
        this.allId = allId;
    }
}
