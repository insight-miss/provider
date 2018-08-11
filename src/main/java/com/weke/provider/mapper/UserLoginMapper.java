package com.weke.provider.mapper;

import com.weke.provider.domain.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserLoginMapper {

    @Insert("insert into user_login(login_city, login_time,login_ip,login_equipment,login_type,user_name) " +
            "values(#{loginCity}, #{loginTime},#{loginIp},#{loginEquipment},#{loginType},#{userName})")
    @Options(useGeneratedKeys=true, keyProperty="loginId")
    Integer insertUserLogin(UserLogin userLogin);

    @Select("select * from user_login where user_name = #{userName}")
    List<UserLogin> getUserLoginInfo(String userName);
}
