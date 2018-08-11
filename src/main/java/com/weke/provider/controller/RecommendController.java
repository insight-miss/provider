package com.weke.provider.controller;


import com.weke.provider.service.RecommendService;
import com.weke.provider.util.RgexUtil;
import com.weke.provider.vo.recommend.AdCourseVo;
import com.weke.provider.vo.recommend.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("recommendApi")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;


    @PostMapping("getAdCourses")
    public List<AdCourseVo> getCourses(@RequestBody String kind) {
        kind = RgexUtil.getListByRgex(kind, "\"(.*?)\"").get(1);
        return recommendService.getAdCourse(kind);
    }

    @PostMapping("updateRecommend")
    public void updateRecommend(@RequestBody Id id){
        System.out.println(id);
        recommendService.changeRemmendByIds(id);
    }
}
