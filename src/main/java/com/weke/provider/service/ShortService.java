package com.weke.provider.service;

import com.weke.provider.mongodb.Question;
import com.weke.provider.vo.teacher.ShortVo;

import java.util.List;

public interface ShortService {

    ShortVo getShortByIndex(Integer index);
}
