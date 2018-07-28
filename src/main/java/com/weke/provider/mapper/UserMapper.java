package com.weke.provider.mapper;

import com.weke.provider.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    User getUserById(Integer id);

    @Select("select * from user where user_name = #{userName}")
    User getUserName(@Param("userName") String userName);

    @Insert("insert into user(user_name, user_password) values(#{userName}, #{userPassword})")
    @Options(useGeneratedKeys=true, keyProperty="userId")
    int addUser(User user);
}
