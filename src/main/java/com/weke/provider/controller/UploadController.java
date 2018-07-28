package com.weke.provider.controller;
 
import com.weke.provider.util.AliyunOSSUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
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
    public String uploadBlog(MultipartFile file){

        System.out.println("上传文件");

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
