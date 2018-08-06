package com.weke.provider.controller;
 
import com.weke.provider.domain.Chapter;
import com.weke.provider.domain.ChapterURl;
import com.weke.provider.util.AliyunOSSUtil;
import com.weke.provider.util.DecodeUTF16;
import com.weke.provider.util.UidGenerator;
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

    /**
     * 文件上传
     * @param file
     */
    @RequestMapping(value = "video")
    public String uploadBlog(MultipartFile file, HttpServletRequest request){

        String catalogName = DecodeUTF16.unicodetoString(request.getHeader("catalogName"));
        String chapterName = DecodeUTF16.unicodetoString(request.getHeader("chapterName"));
        System.out.println(catalogName+" "+chapterName);

        System.out.println("上传文件" +" ");

        String uploadUrl = "null";
 
        try {
            if(null != file){
                String filename = file.getOriginalFilename();
                System.out.println(filename);
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();

                    file.transferTo(newFile);
                    //上传到OSS 返回文件url
                    uploadUrl = AliyunOSSUtil.upload(newFile, uidGenerator.nextIdstr());
                    newFile.delete();
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
//        stringRedisTemplate.opsForValue().set(catalogName, chapterName);
        stringRedisTemplate.opsForValue().set(chapterName, uploadUrl);
        // 一个小时超时
        stringRedisTemplate.expire(chapterName, 1, TimeUnit.HOURS);
        return uploadUrl;
    }

 
}
