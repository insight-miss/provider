package com.weke.provider.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;


public class ConstantProperties implements InitializingBean {


    @Value("${weke.endpoint}")
    private String java4all_file_endpoint;

    @Value("${weke.keyid}")
    private String java4all_file_keyid;

    @Value("${weke.keysecret}")
    private String java4all_file_keysecret;

    @Value("${weke.filehost}")
    private String java4all_file_filehost;

    @Value("${weke.bucketname}")
    private String java4all_file_bucketname1;


    public static String JAVA4ALL_END_POINT;
    public static String JAVA4ALL_ACCESS_KEY_ID;
    public static String JAVA4ALL_ACCESS_KEY_SECRET;
    public static String JAVA4ALL_BUCKET_NAME1;
    public static String JAVA4ALL_FILE_HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        JAVA4ALL_END_POINT = java4all_file_endpoint;
        JAVA4ALL_ACCESS_KEY_ID = java4all_file_keyid;
        JAVA4ALL_ACCESS_KEY_SECRET = java4all_file_keysecret;
        JAVA4ALL_FILE_HOST = java4all_file_filehost;
        JAVA4ALL_BUCKET_NAME1 = java4all_file_bucketname1;
    }

}
