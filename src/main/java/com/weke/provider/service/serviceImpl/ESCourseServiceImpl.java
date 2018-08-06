package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.ESdomain.ESCourse;
import com.weke.provider.repository.ESCourseRepository;
import com.weke.provider.service.ESCourseService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ESCourseServiceImpl implements ESCourseService {

    @Autowired
    ESCourseRepository esCourseRepository;

    @Override
    public ESCourse saveCourse(ESCourse esCourse) {
        return esCourseRepository.save(esCourse);
    }

    @Override
    public void deleteCourse(ESCourse esCourse) {
        esCourseRepository.delete(esCourse);
    }

    @Override
    public Iterable<ESCourse> findCourse(String inputMsg) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(inputMsg);
        builder.analyzer("ik");
        Iterable<ESCourse> iterable = esCourseRepository.search(builder);
        return iterable;
    }

    @Override
    public Page<ESCourse> findAllAndPage(String inputMsg, String page) {
        Integer num = Integer.valueOf(page);
        Page<ESCourse> coursePage = esCourseRepository.findAllByCourseDiffAndCourseNameAndCourseInfo(inputMsg, new PageRequest(num,10));
        return coursePage;
    }
}
