package com.weke.provider.domain;

public class ReplyKid {

    private Integer replykidId;
    private Integer replyId;
    private String replykidInit;
    private String replykidInfo;
    private String replykidEnd;
    private String replykidTime;
    private String replykidLike;// 点赞数

    public ReplyKid() {}

    public ReplyKid(Integer replykidId, Integer replyId, String replykidInit, String replykidInfo, String replykidTime, String replykidLike,String replykidEnd) {
        this.replykidId = replykidId;
        this.replyId = replyId;
        this.replykidInit = replykidInit;
        this.replykidInfo = replykidInfo;
        this.replykidTime = replykidTime;
        this.replykidLike = replykidLike;
        this.replykidEnd = replykidEnd;
    }

    @Override
    public String toString() {
        return "ReplyKid{" +
                "replykidId=" + replykidId +
                ", replyId=" + replyId +
                ", replykidInit='" + replykidInit + '\'' +
                ", replykidInfo='" + replykidInfo + '\'' +
                ", replykidEnd='" + replykidEnd + '\'' +
                ", replykidTime='" + replykidTime + '\'' +
                ", replykidLike='" + replykidLike + '\'' +
                '}';
    }

    public Integer getReplykidId() {
        return replykidId;
    }

    public void setReplykidId(Integer replykidId) {
        this.replykidId = replykidId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplykidInit() {
        return replykidInit;
    }

    public void setReplykidInit(String replykidInit) {
        this.replykidInit = replykidInit;
    }

    public String getReplykidInfo() {
        return replykidInfo;
    }

    public void setReplykidInfo(String replykidInfo) {
        this.replykidInfo = replykidInfo;
    }

    public String getReplykidTime() {
        return replykidTime;
    }

    public void setReplykidTime(String replykidTime) {
        this.replykidTime = replykidTime;
    }

    public String getReplykidEnd() {
        return replykidEnd;
    }

    public void setReplykidEnd(String replykidEnd) {
        this.replykidEnd = replykidEnd;
    }
}
