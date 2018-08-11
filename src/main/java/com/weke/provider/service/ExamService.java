package com.weke.provider.service;

import com.weke.provider.mongodb.Echar;
import com.weke.provider.mongodb.ExamExport;
import com.weke.provider.mongodb.Question;
import com.weke.provider.vo.exam.*;
import com.weke.provider.vo.teacher.TeacherExamVo;
import org.hibernate.cfg.QuerySecondPass;

import java.util.List;

public interface ExamService {

    /**
     * 增加考试
     * @param examInfo
     */
    void insertTestInfo(ExamInfo examInfo , String userName);

    /**
     * 查找所有题集
     * @return
     */
    List<Exams> getAllExam(String userName);

    /**
     * 获取考题具体详细
     * @param id
     * @return
     */
    List<Question> getAllQuestions(Integer id);

    /**
     * 增加用户考试记录
     * @param userExamVo
     */
    void insertUserExam(UserExamVo userExamVo);

    /**
     * 获取答案解析页面
     * @param analysis
     * @return
     */
    ExamExport getAnalysis(Analysis analysis);

    /**
     * 获取个人详细答题页面
     * @param analysis
     * @return
     */
    List<Question> getQuestion(Analysis analysis);

    /**
     * 更新用户答题信息
     * @param userExamVo
     */
    void setQuestions(UserExamVo userExamVo);

    /**
     * 根据出题人 获取题集参与者
     * @param userName
     */
    List<TeacherExamVo> getUserExam(String userName);

    List<RankVo> getRank(Integer testId);
}
