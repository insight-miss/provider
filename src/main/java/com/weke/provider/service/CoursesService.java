package com.weke.provider.service;

import com.weke.provider.vo.CourseVo;

import java.util.List;

public interface CoursesService {

    /**
     * 获取课程详情
     * @return
     */
    public List<CourseVo> getCourse();
}
