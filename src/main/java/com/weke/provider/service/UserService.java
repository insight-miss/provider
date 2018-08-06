package com.weke.provider.service;

import com.weke.provider.domain.User;
import com.weke.provider.vo.UserVo;


public interface UserService {

    /**
     * 通过userId来查找User
     * @param id
     * @return
     */
    UserVo getUserById(Integer id);

    /**
     * 保存
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 通过userId来保存修改
     * @param userVo
     * @param id
     * @return
     */
    int updateUser(UserVo userVo, Integer id);
}
