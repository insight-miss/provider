package com.weke.provider.util;

import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class JudgeAnswerUtil {

    public Integer judgeAnswer(String userAnswer, String answer) {
        if (userAnswer==null || answer==null) {
            return 0;
        }
        String str = "";
        for (int i=0;i<userAnswer.length();i++) {
            char temp = userAnswer.charAt(i);
            if (temp == '1') {
                str =str+"A";
            } else if (temp == '2') {
                str = str+"B";
            } else if (temp == '3') {
                str = str+"C";
            } else {
                str = str+"D";
            }
        }

        if (answer.equals(str)) {
            return 1;
        }
        return 0;
    }
}
