package com.weke.provider.service;

import com.weke.provider.domain.Course;
import com.weke.provider.domain.ESdomain.ESCourse;
import com.weke.provider.vo.CourseVo;
import com.weke.provider.vo.upload.InfoVo;

import java.util.List;

public interface CoursesService {

    /**
     * 获取课程详情
     * @return
     */
    List<CourseVo> getCourse();

    int saveCourse(InfoVo info);

    List<ESCourse> getESCoursesByes(Iterable<ESCourse> iterable);
}
