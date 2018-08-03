package com.weke.provider.controller;

import com.weke.provider.service.ExamService;
import com.weke.provider.vo.teacher.TeacherExamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private ExamService examService;

    @GetMapping("/getUserExam")
    public List<TeacherExamVo> getUserExam(String userName) {
        System.out.println("userName"+userName);
        return examService.getUserExam(userName);
    }
}
