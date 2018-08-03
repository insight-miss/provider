package com.weke.provider.mapper;

import com.weke.provider.domain.UserPermission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserPermissionMapper {

    @Select("select * from user_Permission where user_id = #{id}")
    UserPermission getByUserId(Integer id);

    @Insert("insert into user_Permission(user_id,permission) " +
            "values(#{userId}, #{permission})")
    void insert(UserPermission userPermission);

    @Update("update user_Permission set permission = #{permission} where user_id = #{userId}")
    void updateUserAdmin(@Param("userId")Integer userId,
                         @Param("permission")String permission);
}
