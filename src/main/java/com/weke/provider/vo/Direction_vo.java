package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Direction_vo implements Serializable {
    @JsonProperty("direction")
    private String directionName;
    @JsonProperty("kind")
    private List<String> catalogList;

    public Direction_vo() {
    }

    public Direction_vo(String directionName, List<String> catalogList) {
        this.directionName = directionName;
        this.catalogList = catalogList;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public List<String> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<String> catalogList) {
        this.catalogList = catalogList;
    }

    @Override
    public String toString() {
        return "Direction_vo{" +
                "directionName='" + directionName + '\'' +
                ", catalogList=" + catalogList +
                '}';
    }
}
