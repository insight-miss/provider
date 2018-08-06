package com.weke.provider.repository;


import org.springframework.data.domain.Page;
import com.weke.provider.domain.ESdomain.ESCourse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESCourseRepository extends ElasticsearchRepository<ESCourse, Integer> {

    Page<ESCourse> findAllByCourseDiffAndCourseNameAndCourseInfo(String inputMsg, Pageable pageable);
}
