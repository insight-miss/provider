package com.weke.provider.service;

import com.weke.provider.domain.User;
import com.weke.provider.vo.UserParam;

public interface ALiPayService {

    /**
     * 存取github用户信息
     * @param code
     */
    void getUserInfo(String code);

    /**
     * 前端获取github用户信息接口
     * @return
     */
    UserParam getUserParam();
}
