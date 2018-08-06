package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.User;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.service.UserService;
import com.weke.provider.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserVo getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        UserVo userVo = new UserVo(user.getUserPhoto(), user.getUserName(), user.getUserJob(), user.getUserAddress(), user.getUserSex(), user.getUserSignature());
        return userVo;
    }

    @Override
    public int addUser(User user) {
        System.out.println(user);
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(UserVo userVo, Integer id) {
        System.out.println(userVo);
        return userMapper.updateUser(userVo, id);
    }
}
