package com.weke.provider.controller;

import com.weke.provider.domain.User;
import com.weke.provider.dto.UserPasswordDTo;
import com.weke.provider.exception.UsernameIsExitedException;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.service.UserInfoService;
import com.weke.provider.service.UserLoginInfoService;
import com.weke.provider.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLoginInfoService userLoginInfoService;

    @PostMapping("register")
    public Boolean register(@RequestBody UserParam userParam) {
        System.out.println(userParam);
        return userInfoService.registerUser(userParam);
    }

    @PostMapping("userInfo")
    public List<UserInfoVo> getUserInfo() {
        System.out.println("userInfo");
        return userInfoService.getUserInfo();
    }

    @PostMapping("serUser")
    public String setUserInfo(@RequestBody UserInfoVo userInfoVo) {
        try {
            userInfoService.setUserAdmin(userInfoVo);
        } catch (Exception e) {
            return "false";
        }
        return "true";
    }

    @GetMapping("/sendCode")
    public String sendCode(@Param("phone") String phone) {
        try {
            userInfoService.createSmsCode(phone);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @PostMapping("/checkCode")
    public String checkCod(@Param("phone") String phone,@Param("code") String code) {
//        if (phone == null || code == null) {
//            phone = "15274436893";
//            code = "560597";
//        }
        userInfoService.checkSmsCode(phone,code);
        return "true";
    }

    /**
     * 获取用户登录信息
     * @param userName
     * @return
     */
    @GetMapping("/userLoginInfo")
    public List<UserLoginInfoVo> getUserLoginInfo(String userName) {
        return userLoginInfoService.getUserLoginInfo(userName);
    }

    /**
     * 修改密码
     * @param userPasswordDTo
     * @return
     */
    @PostMapping("/setPassword")
    public Boolean setUserPassword(@RequestBody UserPasswordDTo userPasswordDTo) {
        System.out.println(userPasswordDTo);
        return userInfoService.setPassword(userPasswordDTo);
    }

    @GetMapping("/userPhoto")
    public UserPhotoVo getUserPhoto(@RequestParam("userName") String userName) {
        return userInfoService.getUserPhoto(userName);
    }

    @GetMapping("/userPhoneEmail")
    public PhoneEmailVo getPhoneEmail(@RequestParam("userName") String userName) {
        return userInfoService.getPhoneEmail(userName);
    }
}
