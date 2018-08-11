package com.weke.provider.controller;
 
import com.weke.provider.domain.Chapter;
import com.weke.provider.domain.ChapterURl;
import com.weke.provider.service.UploadService;
import com.weke.provider.service.UserService;
import com.weke.provider.util.AliyunOSSUtil;
import com.weke.provider.util.DecodeUTF16;
import com.weke.provider.util.UidGenerator;
import com.weke.provider.vo.upload.PhototUrl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("upload")
@CrossOrigin
public class UploadController {

    @Autowired
    UidGenerator uidGenerator;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UploadService uploadService;

    @Autowired
    UserService userService;



    /**
     * 文件上传
     * @param file
     */
    @PostMapping(value = "video")
    public String uploadBlog(MultipartFile file, HttpServletRequest request){

        String catalogName = DecodeUTF16.unicodetoString(request.getHeader("catalogName"));
        String chapterName = DecodeUTF16.unicodetoString(request.getHeader("chapterName"));
        System.out.println(catalogName+" "+chapterName);

        System.out.println("shangchuanwenjian" +" ");
        String uploadUrl = uploadService.uploadFile(file);
        stringRedisTemplate.opsForValue().set(chapterName, uploadUrl);
        System.out.println(chapterName+ " ==> "+uploadUrl);
        // 一个小时超时
        stringRedisTemplate.expire(chapterName, 1, TimeUnit.HOURS);
        return uploadUrl;
    }

    @PostMapping("photo")
    public PhototUrl uplodPhoto(MultipartFile file, HttpServletRequest request) {
        String userName = userService.getUserNameByToken(request);
        String uploadUrl = "https://weke-video.oss-cn-beijing.aliyuncs.com/"+uploadService.uploadFile(file);
        userService.updatePhoto(userName, uploadUrl);
        System.out.println(userName+"=====>"+uploadUrl);
        return new PhototUrl(uploadUrl);
    }
}
//./natapp -authtoken=b973c1a1ae7f002c