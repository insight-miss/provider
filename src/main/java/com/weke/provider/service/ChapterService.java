package com.weke.provider.service;

import com.weke.provider.domain.Catalog;
import com.weke.provider.vo.CatalogVo;

import java.util.List;

public interface ChapterService {

    /**
     * 返回课程播放章节目录
     * @param courseName
     * @return
     */
    CatalogVo getCatalogVo(String courseName);
}
