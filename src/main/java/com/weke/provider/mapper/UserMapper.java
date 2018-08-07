package com.weke.provider.mapper;

import com.weke.provider.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    User getUserById(Integer id);

    @Select("select * from user where user_name = #{userName}")
    User getUserName(@Param("userName") String userName);

    @Insert("insert into user(user_name, user_password,user_phone) values(#{userName}, #{userPassword},#{userPhone})")
    @Options(useGeneratedKeys=true, keyProperty="userId")
    int addUser(User user);

    @Insert("insert into user(user_name, user_password,user_photo) values(#{userName}, #{userPassword},#{userPhoto})")
    @Options(useGeneratedKeys=true, keyProperty="userId")
    int insertUser(User user);

    @Select("select user_id from user where user_name = #{userName}")
    Integer getIdByName(@Param("userName")String userName);

    @Select("select * from user")
    List<User> getAllUserInfo();

    @Select("select user_name from user where user_email = #{emailName}")
    String getUserNameByEmail(String emailName);
}
