package com.weke.provider.controller;

import com.weke.provider.domain.ESdomain.ESCourse;
import com.weke.provider.service.CoursesService;
import com.weke.provider.service.ESCourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("searchApi")
public class SearchController {

    @Autowired
    ESCourseService esCourseService;

    @Autowired
    CoursesService coursesService;

    @GetMapping("course")
    public List<ESCourse> searchAllCourses(@Param("inputMsg") String inputMsg, @Param("page") String page) {
        Iterable<ESCourse> iterable = esCourseService.findCourse(inputMsg);
        return coursesService.getESCoursesByes(iterable);
    }

    @GetMapping("courseBypage")
    public List<ESCourse> searchPageCourses(@Param("inputMsg") String inputMsg, @Param("page") String page) {
        Page<ESCourse> coursePage = esCourseService.findAllAndPage(inputMsg, page);
        System.out.println(coursePage);
        List<ESCourse> list = new ArrayList<>();
        for (ESCourse esCourse :coursePage) {
            list.add(esCourse);
        }
        return list;
    }

}
