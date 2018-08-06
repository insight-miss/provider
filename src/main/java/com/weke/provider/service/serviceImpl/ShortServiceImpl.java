package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.weke.provider.domain.Short;
import com.weke.provider.mapper.ShortMapper;
import com.weke.provider.mongodb.Question;
import com.weke.provider.service.ShortService;
import com.weke.provider.vo.teacher.ShortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ShortServiceImpl implements ShortService {

    @Autowired
    private ShortMapper shortMapper;

    @Override
    public ShortVo getShortByIndex(Integer index) {

        Integer totalNumber = shortMapper.getCount();

        PageHelper.startPage(index, 10);
        List<Short> shortList = shortMapper.getAllShort();
        List<Question> questionList = new ArrayList<>();

        for (Short sl: shortList) {
            Question question = new Question();
            question.setType(sl.getShortType());
            question.setProblem(sl.getShortInfo());
            question.setAnswer(sl.getShortAnalysis());
            question.setGrade(sl.getShortScore());
            questionList.add(question);
        }
        ShortVo shortVo = new ShortVo();
        shortVo.setQuestions(questionList);
        shortVo.setTotalNumber(totalNumber);
        return shortVo;
    }
}
