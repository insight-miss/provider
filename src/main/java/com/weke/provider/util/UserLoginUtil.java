package com.weke.provider.util;

import com.weke.provider.domain.UserLogin;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserLoginUtil {

    public UserLogin insertUserLogin(String ip,Integer type,String userName) {
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
        userLogin.setLoginTime(getTime());
        userLogin.setUserName(userName);
        return userLogin;
    }

    public String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }
}
