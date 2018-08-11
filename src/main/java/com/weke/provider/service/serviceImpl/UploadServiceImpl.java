package com.weke.provider.service.serviceImpl;

import com.weke.provider.service.UploadService;
import com.weke.provider.util.AliyunOSSUtil;
import com.weke.provider.util.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Component
public class UploadServiceImpl implements UploadService {

    @Autowired
    UidGenerator uidGenerator;

    @Override
    public String uploadFile(MultipartFile file) {
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
        return uploadUrl;
    }
}
