package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.Comment;
import com.weke.provider.domain.Course;
import com.weke.provider.domain.Problem;
import com.weke.provider.domain.User;
import com.weke.provider.mapper.CommentMapper;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.mapper.ProblemMapper;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.service.ProblemReviewService;
import com.weke.provider.util.TimeUtil;
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

    @Autowired
    private TimeUtil timeUtil;

    @Autowired
    private UserMapper userMapper;

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

            String userPhoto = userMapper.getUserPhotoById(problem.getUserId());

            problemReviewVo.setPhoto(userPhoto);
            problemReviewVo.setComment(problem.getProblemInfo());
            problemReviewVo.setUserId(problem.getProblemId());
            problemReviewVo.setBrowse(problem.getViewNumber().toString());
            problemReviewVo.setTitle(problem.getProblemTitle());
            problemReviewVo.setTime(problem.getProblemTime());
            reviewVos.add(problemReviewVo);
        }
    }

    public void getComment(String courseId,List<ProblemReviewVo> reviewVos) {
        List<Comment> commentList = commentMapper.getCommentById(courseId);

        for (Comment comment : commentList){
            ProblemReviewVo problemReviewVo = new ProblemReviewVo();
            problemReviewVo.setKind("2");
            problemReviewVo.setNum(comment.getPraiseNum());

            User user = userMapper.getUserById(comment.getUserId());

            problemReviewVo.setPhoto(user.getUserPhoto());
            problemReviewVo.setComment(comment.getCommentInfo());
            problemReviewVo.setUserId(comment.getCommentId());

            problemReviewVo.setBrowse(user.getUserName());
            problemReviewVo.setTitle("");
            problemReviewVo.setTime(comment.getCommentTime());
            reviewVos.add(problemReviewVo);
        }
    }


    @Override
    public void insertProblem(ProblemVo problemVo , String userName) {
        Problem problem = new Problem();
        problem.setCourseId(problemVo.getCourseId());
        problem.setProblemTitle(problemVo.getTitle());
        problem.setProblemInfo(problemVo.getInfo());
        problem.setAnswerNum(0);
        Integer userId = userMapper.getIdByName(userName);
        problem.setUserId(userId);
        problem.setViewNumber(0);
        problem.setProblemTime(timeUtil.getTime());
        problemMapper.insert(problem);
    }

    @Override
    public void insertComment(CommentVo commentVo , String userName) {
        Comment comment = new Comment();
        comment.setCommentInfo(commentVo.getInfo());
        comment.setCourseId(commentVo.getCourseName());
        comment.setPraiseNum(0);
        Integer userId = userMapper.getIdByName(userName);
        comment.setUserId(userId);
        comment.setCommentTime(timeUtil.getTime());
        commentMapper.insert(comment);
    }
}
