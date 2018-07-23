package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public class DirectionDetail implements Serializable {
    private String dire;

    private String kind;

    private String diff;

    public DirectionDetail() {
    }

    public DirectionDetail(String dire, String kind, String diff) {
        this.dire = dire;
        this.kind = kind;
        this.diff = diff;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    @Override
    public String toString() {
        return "DirectionDetail{" +
                "dire='" + dire + '\'' +
                ", kind='" + kind + '\'' +
                ", diff='" + diff + '\'' +
                '}';
    }
}
