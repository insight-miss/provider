package com.weke.provider.service;

import com.weke.provider.domain.User;
import com.weke.provider.vo.EmailVo;

public interface EmailService {

    /**
     * 发送邮箱
     * @param emailName
     * @return
     */
    String setEmail(String emailName);

    /**
     * 登录邮箱验证
     * @param token
     * @return
     */
    EmailVo verificationEmail(String token, String emailName);

    /**
     * 绑定邮箱
     * @param token
     * @param emailName
     * @return
     */
    String bindEmail(String token, String emailName);
}
