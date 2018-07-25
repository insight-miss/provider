package com.weke.provider.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.weke.provider.config.ConstantProperties;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AliyunOSSUtil {


    public static String upload(File file) {
//        String endpoint = ConstantProperties.JAVA4ALL_END_POINT;
//        String accessKeyId = ConstantProperties.JAVA4ALL_ACCESS_KEY_ID;
//        String accessKeySecret = ConstantProperties.JAVA4ALL_ACCESS_KEY_SECRET;
//        String bucketName = ConstantProperties.JAVA4ALL_BUCKET_NAME1;
//        String fileHost = ConstantProperties.JAVA4ALL_FILE_HOST;
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAIXfxqPpwWg32d";
        String accessKeySecret = "5vWdV4dleGTHZU6H7c1wsXlYnAXqXV";
        String bucketName = "weke-video";
        String fileHost = "video";
        System.out.println(endpoint+"  "+accessKeyId+" "+accessKeySecret+"  "+bucketName+" "+fileHost);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());

        if (null == file) {
            return null;
        }

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            //容器不存在，就创建
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (null != result) {
                return fileUrl;
            }
        } catch (OSSException oe) {
            System.out.println("OSSException");
        } catch (ClientException ce) {
            System.out.println("ClientException");
        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }
}

