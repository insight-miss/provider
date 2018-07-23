package com.weke.provider.domain;


public class Catalog {
    private Integer catalogId;
    private String catalogName;
    private Integer courseId;

    public Catalog() {
    }

    public Catalog(Integer catalogId, String catalogName, Integer courseId) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.courseId = courseId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
