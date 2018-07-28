package com.weke.provider.util;

import com.weke.provider.domain.UserPermission;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.mapper.UserPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityUtil {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    public String getAuthority(String name) {
        Integer userId = userMapper.getUserName(name).getUserId();
        UserPermission userPermission = userPermissionMapper.getByUserId(userId);
        return userPermission.getPermission();
    }
}
