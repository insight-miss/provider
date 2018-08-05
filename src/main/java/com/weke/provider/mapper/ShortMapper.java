package com.weke.provider.mapper;

import com.weke.provider.domain.Short;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ShortMapper {

    @Select("select * from short where short_id = #{id}")
    Short getById(Integer id);

    @Select("select * from short")
    List<Short> getAllShort();

    @Select("select count(*) from short")
    Integer getCount();
}
