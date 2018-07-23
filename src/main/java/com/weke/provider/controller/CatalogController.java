package com.weke.provider.controller;

import com.weke.provider.service.ChapterService;
import com.weke.provider.vo.CatalogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalog")
@CrossOrigin
public class CatalogController {

    @Autowired
    ChapterService chapterService;

    @GetMapping("info")
    public CatalogVo getCatalog(@RequestParam(value = "courseName",required = false,defaultValue = "分布式框架-Dubbox")
                                            String courseName) {
        System.out.println("courseName:" + courseName);
        return chapterService.getCatalogVo(courseName);
    }
}
