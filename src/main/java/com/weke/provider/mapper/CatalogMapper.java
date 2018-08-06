package com.weke.provider.mapper;

import com.weke.provider.domain.Catalog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CatalogMapper {

    @Insert("insert into catalog(catalog_name,course_id) values(#{catalog.catalogName},#{catalog.courseId})")
    @Options(useGeneratedKeys = true, keyProperty = "catalog.catalogId")
    int insert(@Param("catalog") Catalog catalog);

    @Select("select * from catalog where course_id = #{courseId}")
    List<Catalog> getByCourseId(@Param("courseId") Integer courseId);

    @Select("select * from catalog where catalog_name = #{catalogName}")
    Catalog getCatalogByName(String catalogName);
}
