package com.weke.provider.vo.reply;

import java.io.Serializable;
import java.util.List;

public class ReplyPageVo implements Serializable {

    private MainTitle comment;
    private List<ReplysVo> replys;

    public ReplyPageVo() {}

    public ReplyPageVo(MainTitle comment, List<ReplysVo> replys) {
        this.comment = comment;
        this.replys = replys;
    }

    @Override
    public String toString() {
        return "ReplyPageVo{" +
                "comment=" + comment +
                ", replys=" + replys +
                '}';
    }

    public MainTitle getComment() {
        return comment;
    }

    public void setComment(MainTitle comment) {
        this.comment = comment;
    }

    public List<ReplysVo> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplysVo> replys) {
        this.replys = replys;
    }
}
