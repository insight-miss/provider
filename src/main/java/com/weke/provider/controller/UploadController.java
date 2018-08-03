package com.weke.provider.controller;
 
import com.weke.provider.util.AliyunOSSUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
 

@RestController
@RequestMapping("upload")
@CrossOrigin
public class UploadController {
    /**
     * 文件上传
     * @param file
     */
    @RequestMapping(value = "video")
    public String uploadBlog(MultipartFile file,HttpServletRequest request){

        System.out.println("上传文件"+request.getHeader("catalogName")+" "+request.getHeader("chapterName"));

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
                    uploadUrl = AliyunOSSUtil.upload(newFile);
                    newFile.delete();

                }
 
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return uploadUrl;
    }
 
    @RequestMapping(value = "toUploadBlog",method = RequestMethod.GET)
    public String toUploadBlog(){
        return "upload";
    }
 
}
