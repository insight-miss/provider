package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.UserPermission;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.mapper.UserPermissionMapper;
import com.weke.provider.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void addPermission(String userName) {
        Integer userId = userMapper.getIdByName(userName);
        userPermissionMapper.updateUserAdmin(userId, "Teacher");
        stringRedisTemplate.delete(userName);
    }
}
