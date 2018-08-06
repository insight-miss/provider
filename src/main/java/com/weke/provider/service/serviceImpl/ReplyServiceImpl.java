package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.*;
import com.weke.provider.mapper.*;
import com.weke.provider.service.ReplyService;
import com.weke.provider.vo.reply.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplyServiceImpl implements ReplyService {


    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    ReplyKidMapper replyKidMapper;

    @Autowired
    ProblemMapper problemMapper;

    @Autowired
    UserMapper userMapper;


    @Override
    public ReplyPageVo getAllReplysByCommentId(String problemId) {
        Integer id = Integer.valueOf(problemId);
        Problem problem = problemMapper.getProblemById(Integer.valueOf(problemId));
        System.out.println(problem);
        User user = userMapper.getUserById(problem.getUserId());
        // 获得Comment
        MainTitle mainTitle = new MainTitle(problemId, user.getUserName(), problem.getProblemTitle(), problem.getProblemInfo(),
                "2018-10-15", String.valueOf(problem.getAnswerNum()), String.valueOf(problem.getViewNumber()), user.getUserPhoto());
        List<Reply> replys = replyMapper.getRelysByCommentId(id);
        List<ReplysVo> replysVos = new ArrayList<>();
        for (Reply reply : replys) {
            Integer replyId = reply.getReplyId();
            List<ReplyKid> replyKids = replyKidMapper.getRelyKidsByReplyId(replyId);
            List<DetailVo> detailVos = new ArrayList<>();
            for (ReplyKid replyKid : replyKids) {
                String photo = userMapper.getUserName(replyKid.getReplykidInit()).getUserPhoto();
                // 获得回复
                DetailVo detailVo = new DetailVo(replyKid.getReplykidInit(), replyKid.getReplykidEnd(), replyKid.getReplykidTime(),
                        photo, replyKid.getReplykidInfo());
                detailVos.add(detailVo);
            }
            String photo = userMapper.getUserName(reply.getReplyInit()).getUserPhoto();
            // 获得子评论
            ReplysVo replysVo = new ReplysVo(String.valueOf(replyId), reply.getReplyInit(), photo,
                    reply.getReplyInfo(), reply.getReplyTime(), reply.getReplyLike(), detailVos);
            replysVos.add(replysVo);
        }
        ReplyPageVo pageVo = new ReplyPageVo(mainTitle, replysVos);
        System.out.println(pageVo);
        return pageVo;
    }

    @Override
    public int saveReply(ReplyVo replyVo, String time) {
        Reply reply = new Reply();
        reply.setCommentId(Integer.valueOf(replyVo.getId()));
        reply.setReplyInfo(replyVo.getContent());
        reply.setReplyInit(replyVo.getReplyer());
        reply.setReplyTime(time);
        reply.setReplyLike("0");
        return replyMapper.saveReply(reply);
    }

    @Override
    public int saveReplyKid(ReplyVo replyVo, String time) {
        ReplyKid replyKid = new ReplyKid();
        replyKid.setReplykidEnd(replyVo.getSb());
        replyKid.setReplyId(Integer.valueOf(replyVo.getId()));
        replyKid.setReplykidInfo(replyVo.getContent());
        replyKid.setReplykidInit(replyVo.getReplyer());
        replyKid.setReplykidTime(time);
        return replyKidMapper.saveReply(replyKid);
    }


}
