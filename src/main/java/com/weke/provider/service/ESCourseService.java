package com.weke.provider.service;

import com.weke.provider.domain.ESdomain.ESCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ESCourseService {

    ESCourse saveCourse(ESCourse esCourse);

    void deleteCourse(ESCourse esCourse);

    Iterable<ESCourse> findCourse(String inputMsg);

    Page<ESCourse> findAllAndPage(String inputMsg, String page);
}
