package com.weke.provider.controller;

import com.weke.provider.domain.Short;
import com.weke.provider.mapper.ShortMapper;
import com.weke.provider.mongodb.Question;
import com.weke.provider.service.ExamService;
import com.weke.provider.service.ShortService;
import com.weke.provider.util.AuthorityUtil;
import com.weke.provider.util.TokenUtil;
import com.weke.provider.vo.teacher.ShortVo;
import com.weke.provider.vo.teacher.TeacherExamVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ShortService shortService;

    @Autowired
    private AuthorityUtil authorityUtil;

    @GetMapping("/getUserExam")
    public List<TeacherExamVo> getUserExam(String userName) {

        if (!authorityUtil.isTeacher(userName)) {
            return null;
        }
        System.out.println("userName"+userName);
        return examService.getUserExam(userName);
    }

    @GetMapping("short")
    public ShortVo getShort(@RequestParam(required = true , value = "index") Integer index,
                            HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String userName = new TokenUtil(token).getUserName();
        if (!authorityUtil.isTeacher(userName)) {
            return null;
        }

        System.out.println("index="+index);
        return shortService.getShortByIndex(index);
    }
}
