package com.weke.provider.mapper;

import com.weke.provider.domain.UserExam;
import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Component
@Mapper
public interface UserExamMapper {

    @Insert("insert into user_exam(user_name,test_id,grade,correct_rate,correct_number)" +
            " values(#{userName},#{testId},#{grade},#{correctRate},#{correctNumber})" )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserExam userExam);

    @Select("select * from user_exam where test_id = #{testId} and user_name = #{userName}")
    UserExam getByUserNameAndTestId(@Param("userName") String userName,@Param("testId") Integer testId);

    @Select("select * from user_exam where test_id = #{testId}")
    List<UserExam> getByTestId(@Param("testId") Integer testId);

    @Update("update user_exam set grade=#{grade},correct_rate=#{correctRate},statues=#{statues},correct_number=#{correctNumber} where id = #{id}")
    int update(UserExam userExam);

    @Select("select * from user_exam where test_id = #{testId} order by grade desc")
    List<UserExam> getByTestIdOrderByGrade(Integer testId);
}
