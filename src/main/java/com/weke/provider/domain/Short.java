package com.weke.provider.domain;

public class Short {

    private Integer shortId;
    private String shortInfo;
    private String shortAnalysis;
    private Integer shortScore;
    private Integer shortType;
    private String shortUrl;

    public Short() {

    }

    public Short(Integer shortId, String shortInfo, String shortAnalysis, Integer shortScore, Integer shortType, String shortUrl) {
        this.shortId = shortId;
        this.shortInfo = shortInfo;
        this.shortAnalysis = shortAnalysis;
        this.shortScore = shortScore;
        this.shortType = shortType;
        this.shortUrl = shortUrl;
    }

    public Integer getShortId() {
        return shortId;
    }

    public void setShortId(Integer shortId) {
        this.shortId = shortId;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getShortAnalysis() {
        return shortAnalysis;
    }

    public void setShortAnalysis(String shortAnalysis) {
        this.shortAnalysis = shortAnalysis;
    }

    public Integer getShortScore() {
        return shortScore;
    }

    public void setShortScore(Integer shortScore) {
        this.shortScore = shortScore;
    }

    public Integer getShortType() {
        return shortType;
    }

    public void setShortType(Integer shortType) {
        this.shortType = shortType;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Short{" +
                "shortId=" + shortId +
                ", shortInfo='" + shortInfo + '\'' +
                ", shortAnalysis='" + shortAnalysis + '\'' +
                ", shortScore=" + shortScore +
                ", shortType=" + shortType +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
