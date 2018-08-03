package com.weke.provider.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimeUtil {
    public String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    public String getStatues(String startTime , String endTime) {

        String result = "";

        String currentTime = getTime();
        if (currentTime.compareTo(startTime)<0) {
            result = "未开始";
        }

        if (currentTime.compareTo(startTime)>=0 && currentTime.compareTo(endTime)<=0) {
            result = "进行中";
        }

        if (currentTime.compareTo(endTime) > 0) {
            result = "已完成";
        }

        return result;
    }
}
