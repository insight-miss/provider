package com.weke.provider.util;

import com.weke.provider.domain.UserExam;
import com.weke.provider.mongodb.Echar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EcharUtil {

    public List<Echar> getEchar(List<UserExam> userExams , Integer sumGrade) {
        List<Echar> echarList = new ArrayList<>();

        int num[] = new int[6];
        for (UserExam userExam : userExams) {
            if (userExam.getGrade() <sumGrade * 0.6) {
                num[0]++;
            } else if (userExam.getGrade() <sumGrade * 0.7) {
                num[1]++;
            } else if (userExam.getGrade() <sumGrade * 0.8) {
                num[2]++;
            } else if (userExam.getGrade() <sumGrade * 0.9) {
                num[3]++;
            } else {
                num[4]++;
            }
        }

        for (int i=0;i<5;i++) {
            Echar echar = new Echar();
            if (i==0) {
                echar.setName("60%");
            } else if (i==1) {
                echar.setName("70%");
            } else if (i==2) {
                echar.setName("80%");
            } else if (i==3) {
                echar.setName("90%");
            } else {
                echar.setName("90%以上");
            }
            echar.setValue(num[i]);
            echarList.add(echar);
        }
        return echarList;
    }
}
