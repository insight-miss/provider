package com.weke.provider.service;

import com.weke.provider.dto.UserPasswordDTo;
import com.weke.provider.vo.PhoneEmailVo;
import com.weke.provider.vo.UserInfoVo;
import com.weke.provider.vo.UserParam;
import com.weke.provider.vo.UserPhotoVo;

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

    /**
     * 校验短信验证
     * @param phone
     * @param smsCode
     * @return
     */
    boolean checkSmsCode(String phone,String smsCode);

    /**
     * 修改密码
     * @param userPasswordDTo
     * @return
     */
    boolean setPassword(UserPasswordDTo userPasswordDTo);

    /**
     * 获取用户头像
     * @param userName
     * @return
     */
    UserPhotoVo getUserPhoto(String userName);

    /**
     * 获取用户手机号和邮箱
     * @param userName
     * @return
     */
    PhoneEmailVo getPhoneEmail(String userName);
}
