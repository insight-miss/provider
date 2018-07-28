package com.weke.provider.mapper;

import com.weke.provider.domain.UserPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserPermissionMapper {

    @Select("select * from user_Permission where user_id = #{id}")
    UserPermission getByUserId(Integer id);
}
