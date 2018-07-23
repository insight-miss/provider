package com.weke.provider.domain;

public class Direction {
    private Integer directionId;
    private String directionName;
    private String catalogName;

    public Direction() {
    }

    public Direction(Integer directionId, String directionName, String catalogName) {
        this.directionId = directionId;
        this.directionName = directionName;
        this.catalogName = catalogName;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
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

    @Override
    public String toString() {
        return "Direction{" +
                "directionId=" + directionId +
                ", directionName='" + directionName + '\'' +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }
}
