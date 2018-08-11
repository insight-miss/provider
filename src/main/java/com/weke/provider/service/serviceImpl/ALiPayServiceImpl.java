package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.User;
import com.weke.provider.domain.UserPermission;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.mapper.UserPermissionMapper;
import com.weke.provider.service.ALiPayService;
import com.weke.provider.util.ConstantKey;
import com.weke.provider.util.RgexUtil;
import com.weke.provider.vo.UserParam;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

@Component
@Service
public class ALiPayServiceImpl implements ALiPayService {

    @Autowired
    private Environment environment;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    @Override
    public UserParam getUserParam() {
        UserParam userParam = new UserParam();
        String ALiUserName = stringRedisTemplate.opsForValue().get("ALiUserName");
        String ALiUserPhoto = stringRedisTemplate.opsForValue().get("ALiUserPhoto");

        userParam.setUsername(ALiUserName);
        userParam.setPassword(ALiUserPhoto);
        stringRedisTemplate.delete("ALiUserName");
        stringRedisTemplate.delete("ALiUserPhoto");

        String token =Jwts.builder()
                        .setSubject(ALiUserName + "-" + null)
                        .setExpiration(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)) // 设置过期时间 365 * 24 * 60 * 60秒(这里为了方便测试，所以设置了1年的过期时间，实际项目需要根据自己的情况修改)
                        .signWith(SignatureAlgorithm.HS512, ConstantKey.SIGNING_KEY) //采用什么算法是可以自己选择的，不一定非要采用HS512
                        .compact();
        userParam.setPhone("Bearer " + token);
        System.out.println(userParam);
        return userParam;
    }

    @Override
    public void getUserInfo(String code) {
        String me = sendPost
                ("https://github.com/login/oauth/access_token?client_id="+environment.getProperty("github.client_id")+
                        "&client_secret=" + environment.getProperty("github.Client Secret") +
                        "&code="+code+"&redirect_uri=http://21j6z47736.51mypc.cn/aLiPay/callback",null);

        System.out.println("me="+me);

        String atoke = me.split("&")[0];

        String res = sendGet("https://api.github.com/user?"+atoke+"");

        User user = RgexUtil.getListByRgex(res);
        stringRedisTemplate.opsForValue().set("ALiUserName",user.getUserName());
        stringRedisTemplate.opsForValue().set("ALiUserPhoto",user.getUserPhoto());

        insertUser(user);
    }

    /**
     * 用户授权成功 插入用户信息
     * @param user
     */
    public void insertUser(User user) {
        if (userMapper.getUserName(user.getUserName()) != null) {
            return;
        }

        String password = "user"+ user.getUserPhoto();
        user.setUserPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        userMapper.insertUser(user);

        UserPermission userPermission = new UserPermission();
        userPermission.setUserId(user.getUserId());
        userPermission.setPermission("User");
        userPermissionMapper.insert(userPermission);
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            InputStream instream = conn.getInputStream();
            if(instream!=null){
                in = new BufferedReader( new InputStreamReader(instream));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return result;
    }
    /**
     * 发起http请求获取返回结果
     * @param req_url 请求地址
     * @return
     */
    public static String sendGet(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //res = new String(buffer.toString().getBytes("iso-8859-1"),"utf-8");
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
