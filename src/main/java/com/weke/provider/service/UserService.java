package com.weke.provider.service;

import com.weke.provider.domain.User;
import com.weke.provider.vo.UserVo;

import javax.servlet.http.HttpServletRequest;


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

    /**
     * 根据用户名来更改图片url
     * @param userName
     * @param photoUrl
     * @return
     */
    int updatePhoto(String userName, String photoUrl);

    int getUserIdByToken(HttpServletRequest request);

    String getUserNameByToken(HttpServletRequest request);
}
