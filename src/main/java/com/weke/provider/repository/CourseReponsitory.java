package com.weke.provider.repository;


import com.weke.provider.domain.Course;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CourseReponsitory extends ElasticsearchRepository<Course, Integer> {
}
