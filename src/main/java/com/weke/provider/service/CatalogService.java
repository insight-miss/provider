package com.weke.provider.service;

import com.weke.provider.vo.upload.UploadVo;

import java.util.List;

public interface CatalogService {

    void saveCatalogs(List<UploadVo> catalogs, Integer courseId);

}
