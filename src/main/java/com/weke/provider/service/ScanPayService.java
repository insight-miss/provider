package com.weke.provider.service;

import com.alipay.api.AlipayApiException;

import java.util.Map;

public interface ScanPayService {

    Map<String,String> makeQRcode(String userName, String totalFee) throws AlipayApiException;

    boolean queryOrder(String orderNo) throws AlipayApiException;
}
