package com.weke.provider.service.serviceImpl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.weke.provider.config.aliPay.AliPayConfig;
import com.weke.provider.service.ScanPayService;
import com.weke.provider.util.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;

@Component
public class ScanPayServiceImpl implements ScanPayService {
    
    @Autowired
    private UidGenerator uidGenerator;

    /**
     * 生成订单号及订单二维码url
     * @param userName
     * @param totalFee 需要支付的金额
     * @return
     * @throws AlipayApiException
     */
    @Override
    public Map<String,String> makeQRcode(String userName, String totalFee) throws AlipayApiException {

        String orderNo = uidGenerator.nextIdstr();    //订单号
        String body = "";
        String subject = userName + "want to be publisher";

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.ALIPAY_SERVER_URL, AliPayConfig.APPID, AliPayConfig.RSA2_PRIVATE
                , "json", "UTF-8", AliPayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
        
        //创建API对应的request类
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        //设置业务参数                 "    \"subject\":\"扫码支付\"," +
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + orderNo + "\"," +
                "    \"total_amount\":\"" + totalFee + "\"," +
                "    \"body\":\"" + body + "\"," +
                "    \"subject\":\"to be publiser\"," +
                "    \"timeout_express\":\"90m\"}");
        
        // 异步通知地址
        request.setNotifyUrl(" http://cxgyks.natappfree.cc/ali/notify");

        //通过alipayClient调用API，获得对应的response类
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        System.err.print(response.getBody());
        
        //根据response中的结果继续业务逻辑处理
        if (response.getMsg().equals("Success")) {
            String qrcode = response.getQrCode();
            Map<String, String> map = new HashMap<>();
            map.put(orderNo, qrcode);
            return map;
        } else
            return null;

    }

    @Override
    public boolean queryOrder(String orderNo) throws AlipayApiException {
        System.out.println("orderNo "+orderNo);

        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.ALIPAY_SERVER_URL, AliPayConfig.APPID, AliPayConfig.RSA2_PRIVATE, "json",
                "UTF-8", AliPayConfig.ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + orderNo + "\" " +
                "  }");

        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println(response.getTradeStatus());
            if (response.getTradeStatus().equals("TRADE_FINISHED") || response.getTradeStatus().equals("TRADE_SUCCESS")) {

                return true;
            }
        }catch (Exception e){
            System.out.println("  ");
        }
        return false;
    }

}
