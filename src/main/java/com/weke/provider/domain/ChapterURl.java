package com.weke.provider.domain;

import java.io.Serializable;

public class ChapterURl implements Serializable {

    private String chapterName;
    private String url;

    public ChapterURl() {}

    public ChapterURl(String chapterName, String url) {
        this.chapterName = chapterName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "ChapterURl{" +
                "chapterName='" + chapterName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
