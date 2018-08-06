package com.weke.provider.domain;

public class Chapter {
    private Integer chapterId;
    private String chapterName;
    private String chapterUrl;// 课程视频url
    private Integer catalogId;

    public Chapter() {
    }

    public Chapter(Integer chapterId, String chapterName, String chapterUrl, Integer catalogId) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.chapterUrl = chapterUrl;
        this.catalogId = catalogId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public String toString() {
        return "chapter{" +
                "chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                ", chapterUrl='" + chapterUrl + '\'' +
                ", catalogId=" + catalogId +
                '}';
    }
}
