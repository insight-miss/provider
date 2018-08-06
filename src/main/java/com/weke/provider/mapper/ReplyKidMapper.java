package com.weke.provider.mapper;

import com.weke.provider.domain.ReplyKid;
import com.weke.provider.vo.reply.ReplyVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReplyKidMapper {

    @Insert("insert into replykid(reply_id, replykid_init, replykid_info,replykid_time,replykid_end) values(#{replyId}," +
            " #{replykidInit}, #{replykidInfo}, #{replykidTime},#{replykidEnd})")
    @Options(useGeneratedKeys = true, keyProperty = "replykidId")
    int saveReply(ReplyKid replyKid);

    @Select("select * from replykid where reply_id = #{replyId}")
    List<ReplyKid> getRelyKidsByReplyId(Integer replyId);
}
