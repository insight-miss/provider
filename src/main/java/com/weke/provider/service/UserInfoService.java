package com.weke.provider.service;

import com.weke.provider.vo.UserInfoVo;
import com.weke.provider.vo.UserParam;

import java.util.List;

public interface UserInfoService {

    /**
     * 注册用户
     * @param userParam
     * @return
     */
    Boolean registerUser(UserParam userParam);

    /**
     * 管理员获取用户信息
     * @return
     */
    List<UserInfoVo> getUserInfo();

    /**
     * 修改用户权限
     * @param userInfoVo
     */
    void setUserAdmin(UserInfoVo userInfoVo);

    /**
     * 发送短信验证
     * @param phone
     */
    void createSmsCode(String phone);

    public boolean checkSmsCode(String phone,String smsCode);
}
