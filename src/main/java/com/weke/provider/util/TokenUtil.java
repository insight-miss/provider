package com.weke.provider.util;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

public class TokenUtil {

    private String token;

    public String getToken() {
        return token;
    }

    public TokenUtil(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        String user = Jwts.parser()
                .setSigningKey(ConstantKey.SIGNING_KEY)
                .parseClaimsJws(this.token.replace("Bearer ", ""))
                .getBody()
                .getSubject();

        if (user != null) {
            String userName = user.split("-")[0];
            return userName;
        }
        return null;
    }
}
