package com.weke.provider.domain;

import java.io.Serializable;

public class Reply implements Serializable {

    private Integer replyId;
    private Integer commentId;
    private String replyInit;// 评论者
    private String replyInfo;
    private String replyTime;// 评论时间
    private String replyLike;// 回答数量

    public Reply() {}

    public Reply(Integer replyId, Integer commentId, String replyInit, String replyInfo, String replyTime, String replyLike) {
        this.replyId = replyId;
        this.commentId = commentId;
        this.replyInit = replyInit;
        this.replyInfo = replyInfo;
        this.replyTime = replyTime;
        this.replyLike = replyLike;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", commentId=" + commentId +
                ", replyInit='" + replyInit + '\'' +
                ", replyInfo='" + replyInfo + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", replyLike='" + replyLike + '\'' +
                '}';
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getReplyInit() {
        return replyInit;
    }

    public void setReplyInit(String replyInit) {
        this.replyInit = replyInit;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyLike() {
        return replyLike;
    }

    public void setReplyLike(String replyLike) {
        this.replyLike = replyLike;
    }
}
