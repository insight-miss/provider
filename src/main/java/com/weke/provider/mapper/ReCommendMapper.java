package com.weke.provider.mapper;

import com.weke.provider.domain.Recommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReCommendMapper {

    @Select("select * from recommend where recommend_belong = #{belong}")
    List<Recommend> getRecommendByBelong(String belong);

    @Select("select * from recommend where 1 = 1")
    List<Recommend> getAllRecommend();

    @Update("update recommend set course_id = #{allId} where recommend_id = #{adId}")
    void updateRecommend(@Param("adId") Integer adId, @Param("allId") Integer allId);
}
