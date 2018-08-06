package com.weke.provider.controller;

import com.weke.provider.service.UserService;
import com.weke.provider.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.weke.provider.domain.User;

/**
 * 用户更改信息接口
 */
@RestController
@RequestMapping("userApi")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    /**
     *  用户信息改变，保存信息
     * @param userVo
     * @return
     */
    @PostMapping("changeUser")
    public boolean updateUser(@RequestBody UserVo userVo) {
        System.out.println(userVo);
        if (userService.updateUser(userVo, 5) > 0){
            return true;
        }
        return false;
    }

    /**
     * 添加用户，暂定
     * @param userVo
     * @return
     */
    @PostMapping("add")
    public boolean add(@RequestBody UserVo userVo) {
        User user = new User();
        user.setUserName(userVo.getNickname());
        user.setUserPassword("xxx");
        userService.addUser(user);
        return true;
    }

    /**
     * 通过userId查找用户
     * @return
     */
    @GetMapping("getUser")
    public UserVo getUser() {
        UserVo userVo = userService.getUserById(9);
        return userVo;
    }


}
