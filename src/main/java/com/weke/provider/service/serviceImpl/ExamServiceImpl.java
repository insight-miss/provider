package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.Exam;
import com.weke.provider.domain.User;
import com.weke.provider.domain.UserExam;
import com.weke.provider.mapper.ExamMapper;
import com.weke.provider.mapper.UserExamMapper;
import com.weke.provider.mapper.UserMapper;
import com.weke.provider.mongodb.*;
import com.weke.provider.repository.TestInfoRepository;
import com.weke.provider.repository.UserExamRepository;
import com.weke.provider.service.ExamService;
import com.weke.provider.util.EcharUtil;
import com.weke.provider.util.JudgeAnswerUtil;
import com.weke.provider.util.TimeUtil;
import com.weke.provider.vo.exam.*;
import com.weke.provider.vo.teacher.TeacherExamVo;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    private JudgeAnswerUtil judgeAnswerUtil;

    @Autowired
    private TestInfoRepository testInfoRepository;

    @Autowired
    private UserExamMapper userExamMapper;

    @Autowired
    private UserExamRepository userExamRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EcharUtil echarUtil;

    @Autowired
    MongoTemplate mongoTemplate;


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
            Integer userId = exams.getUserId();
            Integer id = exams.getId();
            User user = userMapper.getUserById(userId);
            UserExam userExam = userExamMapper.getByUserNameAndTestId(user.getUserName(),id);

            if (userExam!=null && userExam.getStatues()!=1) {
                exams.setStatues("待审批");
            }else if ( userExam!=null ) {
                exams.setStatues("已完成");
            } else {
                String statues = timeUtil.getStatues(exams.getStartTime(),exams.getEndTime());
                exams.setStatues(statues);
            }

            examsList.add(exams);

        }

        return examsList;
    }

    @Override
    public List<Question> getAllQuestions(Integer id) {
        TestInfo testInfo = testInfoRepository.findByTestId(id);
        return testInfo.getQuestions();
    }

    @Override
    public void insertUserExam(UserExamVo userExamVo) {
        String userName = userExamVo.getUserName();
        Integer testId = userExamVo.getTestId();

        String examName = examMapper.getNameById(testId);
        Integer sumGrade;
        Integer correctNumber = 0;
        Integer totalNumber = 0;
        Integer choiceScore = 0;
        Integer blankScore = 0;
        Integer answerScore = 0;

        for (Question question : userExamVo.getQuestions()) {
            totalNumber++;
            if (question.getType()!=3) {
                Integer judge = judgeAnswerUtil.judgeAnswer(question.getUserAnswer(),question.getAnswer());
                System.out.println(judge);
                if (judge == 1 ) {
                    correctNumber++;
                    if (question.getType() == 1 || question.getType() == 2) {
                        choiceScore+=question.getGrade();
                    } else if (question.getType() == 4) {
                        blankScore+=question.getGrade();
                    }
                }
            }

        }

        sumGrade=choiceScore+blankScore+answerScore;

        System.out.println(choiceScore+" "+blankScore+" "+answerScore+" "+ sumGrade);

        UserExam userExam = new UserExam();
        userExam.setUserName(userName);
        userExam.setTestId(testId);
        userExam.setGrade(sumGrade);
        userExam.setCorrectRate(correctNumber*100/totalNumber);
        userExam.setCorrectNumber(correctNumber);
        userExamMapper.insert(userExam);

        UserExamInfo userExamInfo = new UserExamInfo();
        userExamInfo.setUserExamId(userExam.getId());

        ExamExport examExport = new ExamExport();
        examExport.setAnswerScore(answerScore);
        examExport.setBlankScore(blankScore);
        examExport.setChoiceScore(choiceScore);
        examExport.setCorrectNumber(correctNumber);
        examExport.setExamName(examName);
        examExport.setTotalNumber(totalNumber);
        examExport.setSumGrade(sumGrade);

        userExamInfo.setExamExport(examExport);
        userExamInfo.setQuestions(userExamVo.getQuestions());
        userExamRepository.save(userExamInfo);
    }

    @Override
    public ExamExport getAnalysis(Analysis analysis) {
        UserExam userExam = userExamMapper.getByUserNameAndTestId(analysis.getUserName(),analysis.getTestId());
        if (userExam!=null) {
            UserExamInfo userExamInfo = userExamRepository.findByUserExamId(userExam.getId());
            if (userExamInfo!=null) {
                ExamExport examExport = userExamInfo.getExamExport();
                List<Echar> echarList= getEchar(analysis.getTestId());
                examExport.seteCharts(echarList);
                return examExport;
            }
        }
        return null;
    }

    public List<Echar> getEchar(Integer testId) {
        List<UserExam> examList = userExamMapper.getByTestId(testId);

        return echarUtil.getEchar(examList);
    }

    @Override
    public List<Question> getQuestion(Analysis analysis) {
        UserExam userExam = userExamMapper.getByUserNameAndTestId(analysis.getUserName(),analysis.getTestId());
        if (userExam!=null) {
            UserExamInfo userExamInfo = userExamRepository.findByUserExamId(userExam.getId());
            if (userExamInfo!=null) {
                 List<Question> questions = userExamInfo.getQuestions();
                 return questions;
            }
        }
        return null;
    }

    @Override
    public void setQuestions(UserExamVo userExamVo) {
        UserExam userExam = updateUserExam(userExamVo);
        updateUserExamInfo(userExamVo,userExam);
    }

    /**
     * 更新用户考试表
     * @param userExamVo
     */
    UserExam updateUserExam(UserExamVo userExamVo) {
        String userName = userExamVo.getUserName();
        Integer testId = userExamVo.getTestId();

        String examName = examMapper.getNameById(testId);

        Integer totalNumber = 0;
        Integer answerScore = 0;
        UserExam userExam = userExamMapper.getByUserNameAndTestId(userName,testId);
        Integer correctNumber = userExam.getCorrectNumber();
        for (Question question: userExamVo.getQuestions()) {
            totalNumber++;
            if (question.getType() == 3) {
                if (question.getStatus()!=null) {
                    correctNumber++;
                    answerScore+=question.getStatus();
                }
            }
        }
        Integer sumGrade = userExam.getGrade() + answerScore;
        userExam.setCorrectRate(correctNumber*100/totalNumber);
        userExam.setGrade(sumGrade);
        userExam.setStatues(1);
        userExam.setCorrectNumber(correctNumber);
        userExamMapper.update(userExam);
        return userExam;
    }

    /**
     * 更新mongodb中用户考试表
     * @param userExamVo
     */
    void updateUserExamInfo(UserExamVo userExamVo,UserExam userExam) {
        UserExamInfo userExamInfo = userExamRepository.findByUserExamId(userExam.getId());

        userExamInfo.setQuestions(userExamVo.getQuestions());

        ExamExport examExport = userExamInfo.getExamExport();
        Integer sumGrade = examExport.getSumGrade();
        examExport.setSumGrade(userExam.getGrade());
        examExport.setAnswerScore(userExam.getGrade()-sumGrade);
        examExport.setCorrectNumber(userExam.getCorrectNumber());

        mongoTemplate.updateFirst(new Query(Criteria.where("userExamId").is(userExam.getId())),
                Update.update("examExport", examExport), UserExamInfo.class);

        mongoTemplate.updateFirst(new Query(Criteria.where("userExamId").is(userExam.getId())),
                Update.update("questions", userExamVo.getQuestions()), UserExamInfo.class);

    }

    @Override
    public List<TeacherExamVo> getUserExam(String userName) {
        Integer userId = userMapper.getIdByName(userName);

        List<Exam> examIdList = examMapper.getExamIdByUserId(userId);

        List<TeacherExamVo> teacherExamVos = new ArrayList<>();

        for (Exam exam : examIdList) {
            List<UserExam> userExamList = userExamMapper.getByTestId(exam.getExamId());

            for (UserExam userExam:userExamList) {
                TeacherExamVo teacherExamVo = new TeacherExamVo();
                teacherExamVo.setExamGrade(userExam.getGrade());
                teacherExamVo.setExamName(exam.getExamName());
                teacherExamVo.setExamStatues(userExam.getStatues());
                teacherExamVo.setUserExamId(userExam.getTestId());
                teacherExamVo.setUserName(userExam.getUserName());
                teacherExamVos.add(teacherExamVo);
            }
        }

        return teacherExamVos;
    }

    @Override
    public List<RankVo> getRank(Integer testId) {
        List<UserExam> userExamList = userExamMapper.getByTestIdOrderByGrade(testId);

        List<RankVo> rankVoList = new ArrayList<>();

        int pos = 1;
        for (UserExam userExam : userExamList) {
            RankVo rankVo = new RankVo();
            rankVo.setRank(pos++);
            rankVo.setGrade(userExam.getGrade());
            rankVo.setName(userExam.getUserName());
            rankVo.setStatues(userExam.getCorrectRate());
            rankVo.setExamName(examMapper.getNameById(testId));
            rankVoList.add(rankVo);
        }
        return rankVoList;
    }
}
