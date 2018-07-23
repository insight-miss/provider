package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

//主页方向详细信息
public class TecDetailVo implements Serializable {
    @JsonProperty("title")
    private String directionName;

    @JsonProperty("tec")
    private String catalogName;

    @JsonProperty("ul")
    private String url;

    public TecDetailVo() {
    }

    public TecDetailVo(String directionName, String catalogName, String url) {
        this.directionName = directionName;
        this.catalogName = catalogName;
        this.url = url;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
