package com.weke.provider.controller;


import com.weke.provider.service.CatalogService;
import com.weke.provider.service.CoursesService;
import com.weke.provider.vo.upload.InfoVo;
import com.weke.provider.vo.upload.UploadInfoVo;
import com.weke.provider.vo.upload.UploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("uploadApi")
public class CourseUplodController {

    @Autowired
    CoursesService coursesService;

    @Autowired
    CatalogService catalogService;

    @PostMapping("saveChapter")
    public void saveChapter(@RequestBody UploadInfoVo uploadInfo) {
        InfoVo info = uploadInfo.getInfo();
        List<UploadVo> uploadVo =  uploadInfo.getCatalog();
        Integer courseId = coursesService.saveCourse(info);
        catalogService.saveCatalogs(uploadVo, courseId);
    }
}
