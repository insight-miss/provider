package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.weke.provider.domain.Course;
import com.weke.provider.domain.ESdomain.ESCourse;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.service.CoursesService;
import com.weke.provider.service.ESCourseService;
import com.weke.provider.util.TimeUtil;
import com.weke.provider.vo.CourseVo;
import com.weke.provider.vo.upload.InfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Component
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    TimeUtil timeUtil;

    @Autowired
    private ESCourseService esCourseService;

    @Override
    public List<CourseVo> getCourse() {
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

    @Override
    public int saveCourse(InfoVo info) {
        // 课程名
        String courseName = info.getCourseName();
        // 课程简介
        String courseInfo = info.getCourseInfo();
        String courseKind = info.getCourseKind();
        Integer coursePeople = 0;
        String courseDiff = info.getCourseDiff();
        Integer courseLevel = Integer.valueOf(info.getCourseLevel());
        String mustKnow = "  ";
        String courseTime = timeUtil.getTime();
        Course course = new Course();
        course.setMustKnow("https://img3.mukewang.com/szimg/5b55356c0001af0105400300.jpg");
        course.setCourseDiff(courseDiff);
        course.setCourseInfo(courseInfo);
        course.setCourseKind(courseKind);
        course.setCourseLevel(courseLevel);
        course.setCourseName(courseName);
        course.setCoursePeople(coursePeople);
        course.setCourseTime(courseTime);
        course.setDirectionId(15);
        ESCourse esCourse = new ESCourse(course.getCourseId(),course.getCourseName(),course.getCourseInfo(),course.getCourseDiff(),course.getCourseKind(),course.getMustKnow());
        esCourseService.saveCourse(esCourse);
        courseMapper.saveCourse(course);
        return course.getCourseId();
    }

    @Override
    public List<ESCourse> getESCoursesByes(Iterable<ESCourse> iterable) {
        Iterator<ESCourse> iterator = iterable.iterator();
        List<ESCourse> esCourses = new ArrayList<>();
        while (iterator.hasNext()) {
            esCourses.add(iterator.next());
        }
        return esCourses;
    }
}
