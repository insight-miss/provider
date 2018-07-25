package com.weke.provider.controller;


import com.weke.provider.service.CoursesService;
import com.weke.provider.service.DirectionsService;
import com.weke.provider.vo.CourseVo;
import com.weke.provider.vo.DirectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 主页界面
 */
@RestController
@RequestMapping("page")
@CrossOrigin
public class PageController {

    @Autowired
    private CoursesService courseService;

    @Autowired
    private DirectionsService directionService;


    /**
     * 获取首页课程信息
     * @return
     */
    @GetMapping("/course")
    public List<CourseVo> getCourse() {
        return courseService.getCourse();
    }

    @GetMapping("direction")
    public List<DirectionVo> getDirection() {
        return directionService.getDirection();
    }
}