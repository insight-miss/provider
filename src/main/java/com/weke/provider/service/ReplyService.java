package com.weke.provider.service;

import com.weke.provider.domain.Reply;
import com.weke.provider.vo.reply.ReplyPageVo;
import com.weke.provider.vo.reply.ReplyVo;
import com.weke.provider.vo.reply.ReplysVo;

public interface ReplyService {

    ReplyPageVo getAllReplysByCommentId(String commentId);

    int saveReply(ReplyVo replyVo, String time);

    int saveReplyKid(ReplyVo replyVo, String time);

}
