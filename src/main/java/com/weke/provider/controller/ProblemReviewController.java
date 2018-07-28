package com.weke.provider.controller;

import com.weke.provider.service.ProblemReviewService;
import com.weke.provider.vo.CommentVo;
import com.weke.provider.vo.ProblemPageVo;
import com.weke.provider.vo.ProblemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("problemReview")
public class ProblemReviewController {

    @Autowired
    ProblemReviewService problemReviewService;

    @GetMapping("info")
    public ProblemPageVo getProblemReview(@RequestParam(value = "courseName",required = false,defaultValue = "分布式框架-Dubbox")
                                                      String courseName) {
        System.out.println("Problem:"+courseName);
        ProblemPageVo problemPageVo = problemReviewService.getByCourseName(courseName);
        return problemPageVo;
    }

    @PostMapping("insertProblem")
    public void insertProblem(@RequestBody ProblemVo problemVo) {
        problemReviewService.insertProblem(problemVo);
    }

    @PostMapping("insertReview")
    public void insertReview(@RequestBody CommentVo commentVo) {
        System.out.println("insertReview"+commentVo);
        problemReviewService.insertComment(commentVo);
    }
}
