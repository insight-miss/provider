package com.weke.provider.controller;


import com.weke.provider.service.CoursesService;
import com.weke.provider.service.DirectionsService;
import com.weke.provider.service.MessageInfoService;
import com.weke.provider.util.TokenUtil;
import com.weke.provider.vo.CourseVo;
import com.weke.provider.vo.DirectionVo;
import com.weke.provider.vo.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private MessageInfoService messageInfoService;


    /**
     * 获取首页课程信息
     * @return
     */
    @GetMapping("/course")
    public List<CourseVo> getCourse(HttpServletRequest request) {
//        String token = request.getHeader("Authorization");
//        TokenUtil tokenUtil = new TokenUtil(token);
//        String userName = tokenUtil.getUserName();
//        System.out.println(userName);
        return courseService.getCourse();
    }

    @GetMapping("direction")
    public List<DirectionVo> getDirection() {
        return directionService.getDirection();
    }

    @GetMapping("putMessage")
    public MessageInfo getMessageInfo() {
        return messageInfoService.getMessage();
    }
}