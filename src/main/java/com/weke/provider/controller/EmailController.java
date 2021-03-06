package com.weke.provider.controller;

import com.weke.provider.service.EmailService;
import com.weke.provider.util.TokenUtil;
import com.weke.provider.vo.EmailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    /**
     * 邮箱绑定
     * @param token
     * @param emailName
     * @return
     */
    @GetMapping("info")
    public String getEmail(@Param("token") String token, @Param("emailName") String emailName) {
        return emailService.bindEmail(token,emailName);
    }

    @GetMapping("sendEmail")
    public String setEmail(@RequestParam("userEmail") String userEmail, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        TokenUtil tokenUtil = new TokenUtil(token);
        String userName = tokenUtil.getUserName();
        emailService.setEmail(userEmail ,userName);
        return "true";
    }
}
