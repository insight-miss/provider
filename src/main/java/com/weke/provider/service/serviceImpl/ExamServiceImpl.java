package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.Exam;
import com.weke.provider.mapper.ExamMapper;
import com.weke.provider.mongodb.Options;
import com.weke.provider.mongodb.Question;
import com.weke.provider.mongodb.TestInfo;
import com.weke.provider.repository.TestInfoRepository;
import com.weke.provider.service.ExamService;
import com.weke.provider.util.TimeUtil;
import com.weke.provider.vo.exam.ExamInfo;
import com.weke.provider.vo.exam.Exams;
import com.weke.provider.vo.exam.Option;
import com.weke.provider.vo.exam.Questions;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private TimeUtil timeUtil;

    @Autowired
    private TestInfoRepository testInfoRepository;

    @Override
    public void insertTestInfo(ExamInfo examInfo) {
        Exams exams = examInfo.getExam();
        String startTime = exams.getStartTime().substring(0,10);
        String endTime = exams.getEndTime().substring(0,10);
        String statues = timeUtil.getStatues(startTime,endTime);

        exams.setStatues(statues);
        exams.setEndTime(endTime);
        exams.setStartTime(startTime);
        exams.setUserId(8);


        Integer testId = insertExam(exams);
        TestInfo testInfo = new TestInfo();
        exams.setId(testId);
        testInfo.setExam(exams);

        List<Question> questions = new ArrayList<>();
        int i = 1;
        for (Questions questions1 : examInfo.getQuestions()) {
            Question question = new Question();
            question.setAnswer(questions1.getAnswer());
            question.setGrade(questions1.getGrade());
            question.setProblem(questions1.getProblem());
            question.setQuestionNumber(i);
            question.setStatus(questions1.getStatus());
            question.setType(questions1.getType());

            List<Options> optionsList = new ArrayList<>();

            int s = 1;
            for (Option option : questions1.getOptions()) {
                Options options = new Options();
                options.setOptionDetails(option.getOptionDetails());
                options.setOptionNumber(s++);
                optionsList.add(options);
            }
            question.setOptions(optionsList);
            questions.add(question);
            i++;
        }

        testInfo.setTestId(testId);
        testInfo.setQuestions(questions);
        testInfoRepository.save(testInfo);
    }


    public Integer insertExam(Exams exam) {
        Exam exam1 = new Exam();
        exam1.setUserId(exam.getUserId());
        exam1.setExamGrade(exam.getGrade());
        exam1.setEndTime(exam.getEndTime());
        exam1.setStartTime(exam.getStartTime());
        exam1.setExamName(exam.getExamTitle());
        exam1.setStatues(exam.getStatues());
        examMapper.insert(exam1);

        return exam1.getExamId();
    }

    @Override
    public List<Exams> getAllExam() {
        List<TestInfo> testInfoList = testInfoRepository.findAll();

        List<Exams> examsList = new ArrayList<>();

        for (TestInfo testInfo : testInfoList) {
            Exams exams = testInfo.getExam();
            examsList.add(exams);
        }

        return examsList;
    }

    @Override
    public List<Question> getAllQuestions(Integer id) {
        TestInfo testInfo = testInfoRepository.findByTestId(id);
        return testInfo.getQuestions();
    }

}
