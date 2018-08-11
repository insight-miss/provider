package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.UserLogin;
import com.weke.provider.mapper.UserLoginMapper;
import com.weke.provider.service.UserLoginInfoService;
import com.weke.provider.util.MyHttpResponse;
import com.weke.provider.util.TimeUtil;
import com.weke.provider.vo.UserLoginInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserLoginInfoServiceImpl implements UserLoginInfoService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private TimeUtil timeUtil;

    @Override
    public void insertUserLogin(String ip , Integer type ,String userName) {
        System.out.println("登录进来没");
        System.out.println(type + " " + userName);
        UserLogin userLogin = new UserLogin();

        String city = MyHttpResponse.cityInfo(ip);
        if (city.equals("")) {
            userLogin.setLoginCity("局域网");
        } else {
            userLogin.setLoginCity(city);
        }

        if (type ==1 ) {
            userLogin.setLoginType("账号登录");
        }
        if (type ==2) {
            userLogin.setLoginType("第三方登录");
        }
        userLogin.setLoginEquipment("Web");
        userLogin.setLoginIp(ip);
        userLogin.setLoginTime(timeUtil.getTime());
        userLogin.setUserName(userName);
        userLoginMapper.insertUserLogin(userLogin);
    }

    @Override
    public List<UserLoginInfoVo> getUserLoginInfo(String userName) {
        List<UserLogin> userLoginList = userLoginMapper.getUserLoginInfo(userName);

        List<UserLoginInfoVo> userLoginInfoVoList = new ArrayList<>();

        for (UserLogin userLogin : userLoginList) {
            UserLoginInfoVo userLoginInfoVo = new UserLoginInfoVo();
            userLoginInfoVo.setLoginCity(userLogin.getLoginCity());
            userLoginInfoVo.setLoginEquipment(userLogin.getLoginEquipment());
            userLoginInfoVo.setLoginIp(userLogin.getLoginIp());
            userLoginInfoVo.setLoginTime(userLogin.getLoginTime());
            userLoginInfoVo.setLoginType(userLogin.getLoginType());
            userLoginInfoVoList.add(userLoginInfoVo);
        }
        return userLoginInfoVoList;
    }
}
