package com.weke.provider.service;

import com.weke.provider.vo.UserLoginInfoVo;

import java.util.List;

public interface UserLoginInfoService {

    /**
     * 记录用户登录信息
     * @param ip
     */
    void insertUserLogin(String ip , Integer type , String userName);

    List<UserLoginInfoVo> getUserLoginInfo(String userName);
}
