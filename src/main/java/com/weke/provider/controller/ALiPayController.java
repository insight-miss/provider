package com.weke.provider.controller;

import com.mongodb.util.JSON;
import com.weke.provider.domain.User;
import com.weke.provider.service.ALiPayService;
import com.weke.provider.service.UserLoginInfoService;
import com.weke.provider.util.IpUtil;
import com.weke.provider.vo.UserParam;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 支付宝回调接口
 *
 *  1:https://github.com/login/oauth/authorize?client_id=e3a5b0739fc1d784e02e&state=123&redirect_uri=http://21j6z47736.51mypc.cn/aLiPay/callback
 *
 *  2:https://github.com/login/oauth/access_token?client_id=e3a5b0739fc1d784e02e&client_secret=383a08fed2295a0c3c43e77e91dfc610e94f5fca
 * Revoke all user tokens&code=0cc5fa4e7546a3859101&redirect_uri=http://21j6z47736.51mypc.cn/aLiPay/callback
 */
@RequestMapping("aLiPay")
@RestController
public class ALiPayController {

    @Autowired
    private ALiPayService aLiPayService;

    @Autowired
    private UserLoginInfoService userLoginInfoService;

    @GetMapping("login")
    @ResponseBody
    public UserParam loginApi(HttpServletRequest request) {
        UserParam userParam = aLiPayService.getUserParam();
        if (userParam.getUsername()!=null) {
            String ip = IpUtil.getClinetIpByReq(request);
            userLoginInfoService.insertUserLogin(ip,2,userParam.getUsername());
        }
        return userParam;
    }

    @GetMapping("callback")
    public String RegisteredByGithub(String code){

        try {
            aLiPayService.getUserInfo(code);
        } catch (Exception e ) {
            return "授权失败";
        }

        return "授权成功";
    }



}
