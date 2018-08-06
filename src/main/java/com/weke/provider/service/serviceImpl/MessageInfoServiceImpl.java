package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.service.MessageInfoService;
import com.weke.provider.vo.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Service
public class MessageInfoServiceImpl implements MessageInfoService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public MessageInfo getMessage() {
        MessageInfo messageInfo = new MessageInfo();
        String title = stringRedisTemplate.opsForValue().get("title");
        String content = stringRedisTemplate.opsForValue().get("content");
        messageInfo.setContent(content);
        messageInfo.setTitle(title);
        return messageInfo;
    }
}
