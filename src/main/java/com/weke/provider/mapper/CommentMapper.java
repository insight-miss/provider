package com.weke.provider.mapper;

import com.weke.provider.domain.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {
    @Insert("insert into comment(praise_num,comment_info,user_id,course_id,comment_time)" +
            " values(#{comment.praiseNum},#{comment.commentInfo},#{comment.userId},#{comment.courseId},#{comment.commentTime})")
    @Options(useGeneratedKeys = true, keyProperty = "comment.commentId")
    int insert(@Param("comment")Comment comment);

    @Select("select * from comment where course_id = #{courseId}")
    List<Comment> getCommentById(@Param("courseId") String courseId);


    // 通过评论id找评论
    @Select("select * from comment comment_id = #{commentId}")
    Comment getCommentBycId(Integer commentId);
}
