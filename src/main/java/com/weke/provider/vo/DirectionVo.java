package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 首页分类
 */
public class DirectionVo implements Serializable {

    @JsonProperty("info")
    private String directionName;

    @JsonProperty("tecList")
    private List<TecDetailVo> tecDetailVoList;

    public DirectionVo() {
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public List<TecDetailVo> getTecDetailVoList() {
        return tecDetailVoList;
    }

    public void setTecDetailVoList(List<TecDetailVo> tecDetailVoList) {
        this.tecDetailVoList = tecDetailVoList;
    }

    @Override
    public String toString() {
        return "DirectionVo{" +
                "directionName='" + directionName + '\'' +
                ", tecDetailVoList=" + tecDetailVoList +
                '}';
    }
}
