package com.weke.provider.controller;


import com.alipay.api.AlipayApiException;
import com.weke.provider.service.PublisherService;
import com.weke.provider.service.ScanPayService;
import com.weke.provider.service.UserPermissionService;
import com.weke.provider.util.RgexUtil;
import com.weke.provider.vo.aliPay.AliPayVo;
import com.weke.provider.vo.aliPay.MsgVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("payApi")
@RestController
public class TBPubliserController {


    @Autowired
    private PublisherService publisherServicel;

    @Autowired
    private ScanPayService scanPayService;

    @Autowired
    private UserPermissionService userPermissionService;


    /**
     * 将订单信息返回
     * @param userName
     * @return
     * @throws AlipayApiException
     */
    @PostMapping("tobePublisher")
    public AliPayVo tobePublisher(@RequestBody String userName) throws AlipayApiException {
        String orderNo = null;
        String qrCode = null;
        String rgex = "\"(.*?)\"";
        userName = RgexUtil.getListByRgex(userName, rgex).get(1);
        String subject = userName+"want to be publisher";
        orderNo = publisherServicel.hasOrder(userName);
        System.out.println(userName);
        System.out.println("ssso "+orderNo);
        // 从未支付或二维码过期
        if (orderNo == null) {
            Map<String, String> map = scanPayService.makeQRcode(userName, "1000.6");
            for (Map.Entry<String, String> m : map.entrySet()) {
                orderNo = m.getKey();
                qrCode = m.getValue();
            }
            // 保存该用户的订单及二维码
            publisherServicel.saveOrder(userName, orderNo, qrCode);
            return new AliPayVo(orderNo, qrCode, "1000.6", subject);
        }
        // 发起支付 还未付款
        qrCode = publisherServicel.getQrcode(orderNo);
        return new AliPayVo(orderNo, qrCode, "1000.6", subject);
    }

    @GetMapping("queryOrder")
    public MsgVo queryOrder(@Param("userName") String userName, @Param("orderId") String orderId) throws AlipayApiException {
        System.out.println(userName);
        boolean has_pay = scanPayService.queryOrder(orderId);
        // 已支付
        System.out.println(has_pay);
        if (has_pay) {
            userPermissionService.addPermission(userName);
            MsgVo msgVo = new MsgVo("success");
            return msgVo;
        }
        MsgVo msgVonew = new MsgVo("false");
        return msgVonew;
    }

}
