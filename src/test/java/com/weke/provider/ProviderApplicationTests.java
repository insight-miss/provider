package com.weke.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串

    @Autowired
    RedisTemplate redisTemplate;//操作对象的

    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().append("msg","hello");
        String str = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(str);
    }

    @Test
    public void contextLoads() {
    }

}
