package com.weke.provider.service;

import com.weke.provider.mongodb.Question;
import com.weke.provider.vo.exam.ExamInfo;
import com.weke.provider.vo.exam.Exams;
import org.hibernate.cfg.QuerySecondPass;

import java.util.List;

public interface ExamService {

    /**
     * 增加考试
     * @param examInfo
     */
    void insertTestInfo(ExamInfo examInfo);

    /**
     * 查找所有题集
     * @return
     */
    List<Exams> getAllExam();

    List<Question> getAllQuestions(Integer id);
}
