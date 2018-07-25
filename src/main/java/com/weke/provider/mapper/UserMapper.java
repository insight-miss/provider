package com.weke.provider.mapper;

import com.weke.provider.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    User getUserById(@Param("user_id") Integer id);

    @Insert("insert into user(user_name, user_password, user_photo, user_phone, user_sex, user_job, user_root, user_email, user_address, user_signature) values()")
    int addUser(@Param("user") User user);

}
