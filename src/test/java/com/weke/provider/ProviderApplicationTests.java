package com.weke.provider;

import com.weke.provider.mongodb.ProblemInfo;
import com.weke.provider.util.EmailUtil;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.method.P;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串

    @Autowired
    RedisTemplate redisTemplate;//操作对象的

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().append("msg","hello");
        String str = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(str);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void updateProblemInfo() {
        ProblemInfo problemInfo = new ProblemInfo();
        problemInfo.setTestId(3);
        problemInfo.setType(1);
        problemInfo.setOptions(null);
        problemInfo.setProblem("怎样批量更新");
        problemInfo.setQuestionNumber(1);
        problemInfo.setTestId(1);
//        mongoTemplate.save(problemInfo);
        mongoTemplate.updateFirst(new Query(Criteria.where("userId").is("2")),
                Update.update("problem", problemInfo.getProblem()), ProblemInfo.class);
        mongoTemplate.updateFirst(new Query(Criteria.where("userId").is("2")),
                Update.update("type", 10), ProblemInfo.class);

    }

    @Test
    public void sendHtmlMail() {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("t1850257253@126.com");
        //接收者
        mainMessage.setTo("15274436893@163.com");
        //发送的标题
        mainMessage.setSubject("欢迎注册weke");
        //发送的内容
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>" +
                "  <a href=\"http:10.0.0.26:8080/email/info\"></a>\n" +
                "</body>\n" +
                "</html>";

        mainMessage.setText(content);

        mailSender.send(mainMessage);
    }

    @Autowired
    private EmailUtil emailUtil;

    @Test
    public void setMail() {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("t1850257253@126.com");
            helper.setTo("15274436893@163.com");
            helper.setSubject("欢迎注册weke");

            String str = "http:10.0.0.26:8080/email/info?token="+emailUtil.getEmail();

            //发送的内容
            String content="<html>\n" +
                    "<body>\n" +
                    "    <h3>欢迎来到weke</h3>" +
                    "  <a href="+str+
                    ">点击授权</a>\n" +
                    "</body>\n" +
                    "</html>";
            helper.setText(content, true);

            mailSender.send(message);
            stringRedisTemplate.opsForValue().append("15274436893@163.com",str);

            stringRedisTemplate.delete("15274436893@163.com");

        } catch (MessagingException e) {
            System.out.println("发送失败");
        }
    }
}
