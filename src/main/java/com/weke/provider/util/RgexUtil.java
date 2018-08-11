package com.weke.provider.util;

import com.weke.provider.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RgexUtil {

    public static User getListByRgex(String soap) {
        String rgex = "(\".*?\")";
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
        }

        list.remove(2);

        String userName = "";
        String url = "";
        for (int i=0 ; i<32;i+=2) {
            if (list.get(i).contains("login")) {
                userName = list.get(i+1);
            }
            if (list.get(i).contains("avatar_url")) {
                url = list.get(i+1);
            }
        }

        User user = new User();
        user.setUserName(userName.substring(1,userName.length()-1));
        user.setUserPhoto(url.substring(1,url.length()-1));
        return user;
    }


}
