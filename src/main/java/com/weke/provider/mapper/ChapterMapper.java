package com.weke.provider.mapper;

import com.weke.provider.domain.Chapter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ChapterMapper {

    @Insert("insert into chapter values(#{chapter.chapterId},#{chapter.chapterName},#{chapter.chapterUrl},#{chapter.catalogId})")
    public int insert(@Param("chapter") Chapter chapter);

    @Select("select * from chapter where catalog_id = #{catalogId}")
    List<Chapter> getByCatalogId(@Param("catalogId") Integer catalogId);
}
