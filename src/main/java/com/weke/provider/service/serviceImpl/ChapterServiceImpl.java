package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.Catalog;
import com.weke.provider.domain.Chapter;
import com.weke.provider.domain.Course;
import com.weke.provider.mapper.CatalogMapper;
import com.weke.provider.mapper.ChapterMapper;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.service.ChapterService;
import com.weke.provider.vo.CatalogVo;
import com.weke.provider.vo.SectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    CatalogMapper catalogMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    ChapterMapper chapterMapper;


    @Override
    public CatalogVo getCatalogVo(String courseName) {
        CatalogVo catalogVo = new CatalogVo();
        Course course = courseMapper.getByCourseName(courseName);

        catalogVo.setInfo(course.getCourseName());

        List<Catalog> catalogs = catalogMapper.getByCourseId(course.getCourseId());
        List<SectionVo> sectionVos = new ArrayList<>();
        for (Catalog catalog : catalogs) {
            List<Chapter> chapters = chapterMapper.getByCatalogId(catalog.getCatalogId());
            SectionVo sectionVo = new SectionVo();
            sectionVo.setTitle(catalog.getCatalogName());
            List<String> chapterName = new ArrayList<>();
            for (Chapter chapter : chapters) {
                chapterName.add(chapter.getChapterName());
            }
            sectionVo.setCourse(chapterName);
            sectionVos.add(sectionVo);
        }
        catalogVo.setSectionVos(sectionVos);
        return catalogVo;
    }
}
