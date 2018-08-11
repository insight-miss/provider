package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.Catalog;
import com.weke.provider.domain.Chapter;
import com.weke.provider.domain.ChapterURl;
import com.weke.provider.mapper.CatalogMapper;
import com.weke.provider.mapper.ChapterMapper;
import com.weke.provider.service.CatalogService;
import com.weke.provider.vo.upload.UploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogMapper catalogMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    RedisTemplate<String, ChapterURl> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 保存章节及小节
     *
     * @param catalogs
     * @param courseId
     */
    @Override
    public void saveCatalogs(List<UploadVo> catalogs, Integer courseId) {
        for (UploadVo catalog : catalogs) {
            String catalogName = catalog.getCatalogName();
            Catalog catalogDo = new Catalog();
            catalogDo.setCourseId(courseId);
            catalogDo.setCatalogName(catalogName);
            catalogMapper.insert(catalogDo);
            Integer catalogId = catalogDo.getCatalogId();
            for (String chapterName : catalog.getChapters()) {
                String chapterUrl = stringRedisTemplate.opsForValue().get(chapterName);
                System.out.println(chapterName+"  "+chapterUrl);
                Chapter chapter = new Chapter();
                chapter.setChapterUrl(chapterUrl);
                chapter.setCatalogId(catalogId);
                chapter.setChapterName(chapterName);
                chapterMapper.insert(chapter);
            }
        }
    }
}
