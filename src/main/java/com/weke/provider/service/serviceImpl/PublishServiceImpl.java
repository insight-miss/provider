package com.weke.provider.service.serviceImpl;

import com.weke.provider.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class PublishServiceImpl implements PublisherService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 判断缓存中是否有订单
     *
     * @param userName
     * @return
     */
    @Override
    public String hasOrder(String userName) {
        return stringRedisTemplate.opsForValue().get(userName);
    }

    /**
     * 保存 username-orderNo orderNo-QRcode
     *
     * @param userName
     * @param orderNo 订单号
     * @param QRcode 二维码url
     */
    @Override
    public void saveOrder(String userName, String orderNo, String QRcode) {
        stringRedisTemplate.opsForValue().set(userName, orderNo);
        stringRedisTemplate.opsForValue().set(orderNo, QRcode);
        // 五个小时之后二维码过期
        stringRedisTemplate.expire(userName, 5, TimeUnit.HOURS);
        stringRedisTemplate.expire(orderNo, 5, TimeUnit.HOURS);
    }

    /**
     * 获得二维码
     *
     * @param orderNo
     * @return
     */
    @Override
    public String getQrcode(String orderNo) {
        return stringRedisTemplate.opsForValue().get(orderNo);
    }
}
