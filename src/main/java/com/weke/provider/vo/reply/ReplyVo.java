package com.weke.provider.vo.reply;

import java.io.Serializable;

public class ReplyVo implements Serializable {
    private String kind;// 种类
    private String id;// 被回复id
    private String sb; // 被回复者名字
    private String replyer;// 回复者
    private String content; // 内容

    public ReplyVo() {}

    public ReplyVo(String kind, String id, String replyer, String content, String sb) {
        this.kind = kind;
        this.id = id;
        this.replyer = replyer;
        this.content = content;
        this.sb = sb;
    }

    @Override
    public String toString() {
        return "ReplyVo{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", sb='" + sb + '\'' +
                ", replyer='" + replyer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplyer() {
        return replyer;
    }

    public void setReplyer(String replyer) {
        this.replyer = replyer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }
}
