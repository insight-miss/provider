package com.weke.provider.service;

import com.weke.provider.vo.recommend.AdCourseVo;
import com.weke.provider.vo.recommend.Id;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RecommendService {
    List<AdCourseVo> getAdCourse(String kind);

    void changeRemmendByIds(Id id);
}
