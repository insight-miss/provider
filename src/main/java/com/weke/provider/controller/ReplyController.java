package com.weke.provider.controller;


import com.weke.provider.service.ReplyService;
import com.weke.provider.util.TimeUtil;
import com.weke.provider.vo.reply.ReplyPageVo;
import com.weke.provider.vo.reply.ReplyVo;
import com.weke.provider.vo.reply.ReplysVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("replyApi")
@CrossOrigin
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @Autowired
    TimeUtil timeUtil;

    @GetMapping("detail")
    public ReplyPageVo getReplys(String commentId) {
        System.out.println(commentId);
        return replyService.getAllReplysByCommentId(commentId);
    }

    @PostMapping("saveReply")
    public boolean saveRelys(@RequestBody ReplyVo replyVo) {
        System.out.println(replyVo);
        String time = timeUtil.getTime();
        // 直接评论
        if (replyVo.getKind().equals("1") && replyService.saveReply(replyVo, time) > 0) {
            return true;
        } else if (replyVo.getKind().equals("2") && replyService.saveReplyKid(replyVo, time) > 0) { // 评论回复
            return true;
        }
        return false;
    }
}
