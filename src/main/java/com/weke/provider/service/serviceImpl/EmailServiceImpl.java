package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.User;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.service.EmailService;
import com.weke.provider.util.ConstantKey;
import com.weke.provider.util.EmailUtil;
import com.weke.provider.vo.EmailVo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public String setEmail(String emailName,String userName) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("t1850257253@126.com");
//            helper.setTo("15274436893@163.com");
            helper.setTo(emailName);
            helper.setSubject("欢迎注册weke");

            String token = emailUtil.getEmail();
            String str = "http:10.0.0.26:8080/email/info?token="+token+"&emailName="+emailName;

            //发送的内容
            String content="<html>\n" +
                    "<body>\n" +
                    "    <h3>欢迎来到weke</h3>" +
                    "  <a href="+str+
                    ">点击授权</a>\n" +
                    "</body>\n" +
                    "</html>";

            helper.setText(content, true);

            javaMailSender.send(message);

            stringRedisTemplate.opsForValue().set(emailName,token);
            stringRedisTemplate.opsForValue().set("emailUserName",userName);

        } catch (MessagingException e) {
            System.out.println("发送失败");
        }
        return null;
    }

    @Override
    public EmailVo verificationEmail(String token , String emailName) {
        String userToken = stringRedisTemplate.opsForValue().get(emailName);

        if (!userToken.equals(token)) {
            return null;
        }

        stringRedisTemplate.delete(emailName);

        String userName = userMapper.getUserNameByEmail(emailName);
        String tokens = Jwts.builder()
                .setSubject(userName + "-" + null)
                .setExpiration(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)) // 设置过期时间 365 * 24 * 60 * 60秒(这里为了方便测试，所以设置了1年的过期时间，实际项目需要根据自己的情况修改)
                .signWith(SignatureAlgorithm.HS512, ConstantKey.SIGNING_KEY) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();

        EmailVo emailVo = new EmailVo();
        emailVo.setToken(tokens);
        emailVo.setUserName(userName);
        return emailVo;
    }

    @Override
    public String bindEmail(String token, String emailName) {

        System.out.println(emailName);

        String userToken = stringRedisTemplate.opsForValue().get(emailName);
        String userName = stringRedisTemplate.opsForValue().get("emailUserName");
        if (!userToken.equals(token)) {
            return "false";
        }
        stringRedisTemplate.delete(emailName);
        stringRedisTemplate.delete("emailUserName");

        userMapper.updateEmailByUserName(userName,emailName);
        return "true";
    }
}
