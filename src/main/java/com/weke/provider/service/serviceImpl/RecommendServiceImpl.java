package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.Course;
import com.weke.provider.domain.Recommend;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.mapper.ReCommendMapper;
import com.weke.provider.service.RecommendService;
import com.weke.provider.vo.recommend.AdCourseVo;
import com.weke.provider.vo.recommend.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private ReCommendMapper reCommendMapper;

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 判断kind种类获得课程
     * kind 1 返回广告课程
     * kind 2 返回所有备选课程
     * @param kind
     * @return
     */
    public List<AdCourseVo> getAdCourse(String kind) {

        List<AdCourseVo> adCourseVos = new ArrayList<>();

        // 获得所有广告课程
        if (kind.equals("1")) {
            List<Recommend> recommends = reCommendMapper.getAllRecommend();
            for (Recommend recommend: recommends) {
                AdCourseVo adCourseVo = new AdCourseVo();
                Course course = courseMapper.getCourseById(recommend.getCourseId());
                adCourseVo.setId(recommend.getRecommendId());
                adCourseVo.setBleng(recommend.getrecommendBelong());
                adCourseVo.setCourseName(course.getCourseName());
                adCourseVo.setImgSrc(course.getMustKnow());
                adCourseVo.setKind(course.getCourseDiff());
                adCourseVo.setInfo(course.getCourseInfo());
                adCourseVos.add(adCourseVo);
            }
            return adCourseVos;
        }
        // 获取所有课程
        List<Course> courses = courseMapper.getAllCourses();

        for (Course course : courses) {
            AdCourseVo  adCourseVo = new AdCourseVo(course.getCourseId(),course.getCourseName(),course.getMustKnow(),course.getCourseKind(),course.getCourseInfo(),"");
            adCourseVos.add(adCourseVo);
        }

        return adCourseVos;
    }

    public void changeRemmendByIds(Id id) {
        Integer adId = id.getAdId()+1;
        Integer allId = id.getAllId();
        reCommendMapper.updateRecommend(adId, allId);
    }
}
