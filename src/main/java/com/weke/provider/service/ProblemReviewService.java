package com.weke.provider.service;

import com.weke.provider.vo.CommentVo;
import com.weke.provider.vo.ProblemPageVo;
import com.weke.provider.vo.ProblemReviewVo;
import com.weke.provider.vo.ProblemVo;

import java.util.List;

/**
 * 问题评论服务
 */
public interface ProblemReviewService {

    /**
     * 通过课程名获取 问题评论信息
     * @param courseName
     * @return
     */
    ProblemPageVo getByCourseName(String courseName);

    /**
     * 发表问题
     * @param problemVo
     */
    void insertProblem(ProblemVo problemVo);

    /**
     * 发表评论
     * @param commentVo
     */
    void insertComment(CommentVo commentVo);
}
