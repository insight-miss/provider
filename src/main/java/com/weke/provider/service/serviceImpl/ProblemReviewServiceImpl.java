package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.Comment;
import com.weke.provider.domain.Course;
import com.weke.provider.domain.Problem;
import com.weke.provider.mapper.CommentMapper;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.mapper.ProblemMapper;
import com.weke.provider.service.ProblemReviewService;
import com.weke.provider.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ProblemReviewServiceImpl implements ProblemReviewService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ProblemMapper problemMapper;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public ProblemPageVo getByCourseName(String courseName) {
        ProblemPageVo problemPageVo = new ProblemPageVo();
        List<ProblemReviewVo> problemReviewVoList = new ArrayList<>();

        Course course = courseMapper.getByCourseName(courseName);

        getProblem(course.getCourseName(),problemReviewVoList);
        getComment(course.getCourseName(),problemReviewVoList);

        problemPageVo.setProblemReviewVos(problemReviewVoList);

        problemPageVo.setLearnTimeVo(getLearTimeVo(course.getMustKnow()));
        return problemPageVo;
    }

    public LearnTimeVo getLearTimeVo(String mustKnow) {
        LearnTimeVo learnTimeVo = new LearnTimeVo();
        learnTimeVo.setMustKnow(mustKnow);
        learnTimeVo.setLastLearn("");
        learnTimeVo.setStudyPercent(1);
        learnTimeVo.setStudyTime("");
        return  learnTimeVo;
    }

    /**
     * 获取问题信息
     * @param courseId
     * @param reviewVos
     */
    public void getProblem(String courseId,List<ProblemReviewVo> reviewVos) {

        List<Problem> problems = problemMapper.getByCourseId(courseId);

        for (Problem problem : problems) {
            ProblemReviewVo problemReviewVo = new ProblemReviewVo();
            problemReviewVo.setKind("1");
            problemReviewVo.setNum(problem.getAnswerNum());
            problemReviewVo.setPhoto("");
            problemReviewVo.setComment(problem.getProblemInfo());
            problemReviewVo.setUserId(problem.getUserId());
            problemReviewVo.setBrowse(problem.getViewNumber().toString());
            problemReviewVo.setTitle(problem.getProblemTitle());
            problemReviewVo.setTime("2018-10-10");
            reviewVos.add(problemReviewVo);
        }
    }

    public void getComment(String courseId,List<ProblemReviewVo> reviewVos) {
        List<Comment> commentList = commentMapper.getCommentById(courseId);

        for (Comment comment : commentList){
            ProblemReviewVo problemReviewVo = new ProblemReviewVo();
            problemReviewVo.setKind("2");
            problemReviewVo.setNum(comment.getPraiseNum());
            problemReviewVo.setPhoto("");
            problemReviewVo.setComment(comment.getCommentInfo());
            problemReviewVo.setUserId(comment.getUserId());
            problemReviewVo.setBrowse(comment.getCourseId());
            problemReviewVo.setTitle("");
            problemReviewVo.setTime("2018-10-10");
            reviewVos.add(problemReviewVo);
        }
    }


    @Override
    public void insertProblem(ProblemVo problemVo) {
        Problem problem = new Problem();
        problem.setCourseId(problemVo.getCourseId());
        problem.setProblemTitle(problemVo.getTitle());
        problem.setProblemInfo(problemVo.getInfo());
        problem.setAnswerNum(0);
        problem.setUserId(1);
        problem.setViewNumber(0);
        problemMapper.insert(problem);
    }

    @Override
    public void insertComment(CommentVo commentVo) {
        Comment comment = new Comment();
        comment.setCommentInfo(commentVo.getInfo());
        comment.setCourseId(commentVo.getCourseName());
        comment.setPraiseNum(0);
        comment.setUserId(1);
        commentMapper.insert(comment);
    }
}
