package com.weke.provider.mapper;

import com.weke.provider.domain.Comment;
import com.weke.provider.domain.Exam;
import org.apache.ibatis.annotations.*;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ExamMapper {

    @Insert("insert into exam(exam_name,start_time,end_time,statues,exam_grade,user_id)" +
            " values(#{exam.examName},#{exam.startTime},#{exam.endTime},#{exam.statues},#{exam.examGrade},#{exam.userId})" )
    @Options(useGeneratedKeys = true, keyProperty = "exam.examId")
    int insert(@Param("exam")Exam exam);

    @Select("select exam_name from exam where exam_id = #{id}")
    String getNameById(Integer id);

    @Select("select * from exam where user_id = #{userId}")
    List<Exam> getExamIdByUserId(Integer userId);

    @Select("select exam_grade from exam where exam_id = #{id}")
    Integer getGradeById(Integer id);
}
