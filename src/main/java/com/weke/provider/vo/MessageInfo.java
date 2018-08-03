package com.weke.provider.vo;

import java.io.Serializable;

public class MessageInfo implements Serializable {

    private String title;
    private String content;

    public MessageInfo() {

    }

    public MessageInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
