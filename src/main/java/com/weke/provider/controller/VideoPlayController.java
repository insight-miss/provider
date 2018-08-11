package com.weke.provider.controller;

import com.weke.provider.service.VideoService;
import com.weke.provider.vo.VideoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("videoApi")
@CrossOrigin
public class VideoPlayController {

    @Autowired
    VideoService videoService;

    @GetMapping("getVideo")
    public VideoVo getVideoUrl(@Param("catalogName") String catalogName, @Param("chapterName") String chapterName, HttpServletRequest httpServletRequest) {
        System.out.println(catalogName+ " "+chapterName );
        String nickname = "让让群";
        System.out.println("nickname "+nickname);
        VideoVo videoVo = videoService.getVideoVoByChapterCatalog(catalogName, chapterName, nickname);
        return videoVo;
    }

}
