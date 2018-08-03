package com.weke.provider.mapper;

import com.weke.provider.domain.Problem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProblemMapper {

    @Insert("insert into problem(answer_num,user_id,problem_info,view_number,problem_title,course_id,problem_time)" +
            " values(#{problem.answerNum},#{problem.userId},#{problem.problemInfo},#{problem.viewNumber},#{problem.problemTitle},#{problem.courseId},#{problem.problemTime})")
    @Options(useGeneratedKeys = true, keyProperty = "problem.problemId")
    int insert(@Param("problem")Problem problem);

    @Select("select * from problem where course_id = #{courseId}")
    List<Problem> getByCourseId(@Param("courseId") String courseId);
}
