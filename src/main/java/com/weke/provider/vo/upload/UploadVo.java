package com.weke.provider.vo.upload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;

public class UploadVo implements Serializable {

    private String catalogName;
    
    private String[] chapters;

    public UploadVo() {}

    @Override
    public String toString() {
        return "UploadVo{" +
                "catalogName='" + catalogName + '\'' +
                ", chapters=" + Arrays.toString(chapters) +
                '}';
    }

    public UploadVo(String catalogName, String[] chapters) {
        this.catalogName = catalogName;
        this.chapters = chapters;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String[] getChapters() {
        return chapters;
    }

    public void setChapters(String[] chapters) {
        this.chapters = chapters;
    }
}
