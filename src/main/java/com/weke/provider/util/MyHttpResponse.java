package com.weke.provider.util;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.io.IOException;

public class MyHttpResponse {

    public static String cityInfo(String ip) {

        String url = "https://restapi.amap.com/v3/ip?" +
                "ip=" + ip +
                "&output=json&" +
                "key=b848364f927444bdf0eb8273100047f1";
        System.out.println(url);
        String str = MyHttpResponse.getHtml(url, " ", " ");
        System.out.println(str);
        String city = str.split(",")[4].split(":")[1];
        city = city.substring(1,city.length()-1);
        return city;
    }

    public static String getHtml(String url, String ip, String port) {
        //httpclient 获取html信息
        String entity = null;
        String xici = "www.xicidaili.com";
        String nk = "www.nowcoder.com";
        ip =  "202.99.172.165";
        port = "8081";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        System.out.println(Thread.currentThread().getName() + " " + ip + " :" + port);
        // 设置代理
        HttpHost proxy = new HttpHost(ip, Integer.valueOf(port));
        RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectionRequestTimeout(3000)
                .setSocketTimeout(3000).build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);

        // 设置请求头
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;" +
                "q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Connection", "keep-alive");
//        httpGet.setHeader("Host", nk);
        httpGet.setHeader("Pragma", "no-cache");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("User-Agent", "MMozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36" +
                " (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36");

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            System.out.println("status "+httpResponse.getStatusLine().getStatusCode());
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                entity = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
            }
            httpResponse.close();
            httpClient.close();
        } catch (IOException e) {
            System.out.println("come");
            e.printStackTrace();
        }
        // 返回Html信息
        return entity;
    }
}
