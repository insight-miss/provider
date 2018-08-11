package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.User;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.service.UserPermissionService;
import com.weke.provider.service.UserService;
import com.weke.provider.util.AuthorityUtil;
import com.weke.provider.util.TokenUtil;
import com.weke.provider.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private AuthorityUtil authorityUtil;

    @Override
    public UserVo getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        String permission = authorityUtil.getAuthority(user.getUserName());
        UserVo userVo = new UserVo(user.getUserPhoto(), user.getUserName(), user.getUserJob(), user.getUserAddress(), user.getUserSex(), user.getUserSignature(), permission);
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

    @Override
    public int updatePhoto(String userName, String photoUrl) {
        System.out.println("更新头像 "+userName+" "+photoUrl);
        return userMapper.updatePhoto(userName, photoUrl);
    }

    public int getUserIdByToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        TokenUtil tokenUtil = new TokenUtil(token);
        String userName = tokenUtil.getUserName();
        Integer id = userMapper.getIdByName(userName);
        return id;
    }

    public String getUserNameByToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        TokenUtil tokenUtil = new TokenUtil(token);
        String userName = tokenUtil.getUserName();
        return userName;
    }
}
