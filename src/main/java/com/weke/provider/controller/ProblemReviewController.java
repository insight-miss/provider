package com.weke.provider.controller;

import com.weke.provider.service.ProblemReviewService;
import com.weke.provider.util.TokenUtil;
import com.weke.provider.vo.CommentVo;
import com.weke.provider.vo.ProblemPageVo;
import com.weke.provider.vo.ProblemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public void insertProblem(@RequestBody ProblemVo problemVo , HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String userName = new TokenUtil(token).getUserName();

        problemReviewService.insertProblem(problemVo , userName);
    }

    @PostMapping("insertReview")
    public void insertReview(@RequestBody CommentVo commentVo , HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String userName = new TokenUtil(token).getUserName();

        problemReviewService.insertComment(commentVo , userName);
    }
}
