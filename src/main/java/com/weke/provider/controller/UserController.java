package com.weke.provider.controller;

import com.weke.provider.domain.User;
import com.weke.provider.exception.UsernameIsExitedException;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.vo.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("register")
    public String sigin(@RequestBody UserParam userParam) {
        User user = userMapper.getUserName(userParam.getUsername());
        if (null!=user) {
            throw new UsernameIsExitedException("用户已经存在");
        }

        userParam.setPassword(BCrypt.hashpw(userParam.getPassword(), BCrypt.gensalt()));
        User uses = new User();
        uses.setUserName(userParam.getUsername());
        uses.setUserPassword(userParam.getPassword());
        userMapper.addUser(uses);
        System.out.println(userParam.getPassword());

        return "true";
    }

}
