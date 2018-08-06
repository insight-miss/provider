package com.weke.provider.mapper;


import com.weke.provider.domain.Reply;
import com.weke.provider.vo.reply.ReplyVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReplyMapper {

    @Insert("insert into reply(comment_id, reply_init, reply_info, reply_like, reply_time) values(#{commentId}, #{replyInit}, #{replyInfo},#{replyLike},#{replyTime})")
    @Options(useGeneratedKeys = true, keyProperty = "replyId")
    int saveReply(Reply reply);

    @Select("select * from reply where comment_id = #{commentId}")
    List<Reply> getRelysByCommentId(Integer commentId);

}
