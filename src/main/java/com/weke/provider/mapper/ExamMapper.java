package com.weke.provider.mapper;

import com.weke.provider.domain.Comment;
import com.weke.provider.domain.Exam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExamMapper {

    @Insert("insert into exam(exam_name,start_time,end_time,statues,exam_grade,user_id)" +
            " values(#{exam.examName},#{exam.startTime},#{exam.endTime},#{exam.statues},#{exam.examGrade},#{exam.userId})" )
    @Options(useGeneratedKeys = true, keyProperty = "exam.examId")
    int insert(@Param("exam")Exam exam);
}
