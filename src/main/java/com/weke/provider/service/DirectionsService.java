package com.weke.provider.service;

import com.weke.provider.vo.DirectionDetailsVo;
import com.weke.provider.vo.DirectionVo;

import java.util.List;

public interface DirectionsService {

    public List<DirectionVo> getDirection();

    /**
     * 获取方向详情页面数据
     * @param directionName
     * @param catalogName
     * @param courseDiff
     * @return
     */
    public DirectionDetailsVo getDirectionDetails(String directionName,String catalogName,String courseDiff);
}
