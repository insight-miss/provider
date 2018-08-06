package com.weke.provider.mapper;

import com.weke.provider.domain.User;
import com.weke.provider.vo.UserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    User getUserById(Integer id);

    @Select("select * from user where user_name = #{nickname}")
    User getUserByNickName(String nickName);

    @Select("select * from user where user_name = #{userName}")
    User getUserName(@Param("userName") String userName);

    @Insert("insert into user(user_name, user_password) values(#{userName}, #{userPassword})")
    @Options(useGeneratedKeys=true, keyProperty="userId")
    int addUser(User user);

    @Update("update user set user_name=#{userVo.nickname}, user_photo=#{userVo.url}, user_sex=#{userVo.sex}, user_address=#{userVo.address}, user_job=#{userVo.job}, user_signature=#{userVo.signature}" +
            "where user_id=#{id}")
    int updateUser(@Param("userVo") UserVo userVo, @Param("id") Integer id);

}
