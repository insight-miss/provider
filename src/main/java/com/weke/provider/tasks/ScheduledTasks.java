package com.weke.provider.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private StringRedisTemplate redisTemplate;

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        redisTemplate.opsForValue().set("title","斗破苍穹");
//        redisTemplate.opsForValue().set("content","《斗破苍穹》是一本连载于起点中文网的古装玄幻小说，作者是起点白金作家天蚕土豆（李虎），已完结。这里是属于斗气的世界，没有花俏艳丽的魔法，有的，仅仅是繁衍到巅峰的斗气...");
//    }
}