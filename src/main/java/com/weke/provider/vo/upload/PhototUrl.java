package com.weke.provider.vo.upload;

import java.io.Serializable;

public class PhototUrl implements Serializable {
    private String url;

    public PhototUrl() {}

    public PhototUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PhototUrl{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
