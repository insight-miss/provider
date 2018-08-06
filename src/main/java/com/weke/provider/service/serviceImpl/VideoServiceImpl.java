package com.weke.provider.service.serviceImpl;

import com.weke.provider.domain.Catalog;
import com.weke.provider.domain.Chapter;
import com.weke.provider.mapper.CatalogMapper;
import com.weke.provider.mapper.ChapterMapper;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.service.VideoService;
import com.weke.provider.vo.VideoVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CatalogMapper catalogMapper;

    @Override
    public VideoVo getVideoVoByChapterCatalog(String catalogName, String chapterName, String nickname) {
        Catalog catalog = catalogMapper.getCatalogByName(catalogName);
        Chapter chapter = chapterMapper.getChapterByNameAndCatalogId(chapterName, catalog.getCatalogId());
        String videoUrl = "https://weke-video.oss-cn-beijing.aliyuncs.com/"+chapter.getChapterUrl();
        String photoUrl = userMapper.getUserByNickName(nickname).getUserPhoto();
        VideoVo videoVo = new VideoVo(videoUrl, photoUrl, nickname);
        return videoVo;
    }
}
