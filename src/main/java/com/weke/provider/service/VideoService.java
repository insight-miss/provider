package com.weke.provider.service;

import com.weke.provider.vo.VideoVo;

public interface VideoService {

    /**
     * 通过课程名+章节名 查找url
     * @param catalogName
     * @param chapterName
     * @param nickname
     * @return
     */
    VideoVo getVideoVoByChapterCatalog(String catalogName, String chapterName, String nickname);


}
