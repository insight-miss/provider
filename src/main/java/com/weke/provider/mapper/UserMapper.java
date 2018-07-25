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

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);

    @Insert("insert into user(userName,)")
    int addUser(@Param("user") User user);

}
