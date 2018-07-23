package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.weke.provider.domain.Course;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.service.CoursesService;
import com.weke.provider.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseVo> getCourse() {
        PageHelper.startPage(1,5);
        List<Course> courseList = courseMapper.getCourse();
        List<CourseVo> courseVos = new ArrayList<>();

        for (Course course : courseList) {
            CourseVo courseVo = new CourseVo();
            courseVo.setCourseName(course.getCourseName());
            courseVo.setCourseKind(course.getCourseKind());
            courseVo.setCourseDiff(course.getCourseDiff());
            courseVo.setCoursePeople(course.getCoursePeople());
            courseVo.setCourseLevel(course.getCourseLevel());
            courseVos.add(courseVo);
        }
        return courseVos;
    }
}
