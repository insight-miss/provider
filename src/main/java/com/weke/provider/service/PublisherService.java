package com.weke.provider.service;

public interface PublisherService {

    String hasOrder(String userName);

    void saveOrder(String userName, String orderNo, String QRcode);

    String getQrcode(String orderNo);
}
