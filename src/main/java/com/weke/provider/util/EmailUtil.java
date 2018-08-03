package com.weke.provider.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailUtil {

    public String getEmail() {
        long timeMillis = System.currentTimeMillis();
        String email = timeMillis + "";
        return email;
    }
}
