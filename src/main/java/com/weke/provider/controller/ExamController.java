package com.weke.provider.controller;

import com.weke.provider.mapper.ExamMapper;
import com.weke.provider.mongodb.*;
import com.weke.provider.repository.TestInfoRepository;
import com.weke.provider.repository.UserExamRepository;
import com.weke.provider.service.ExamService;
import com.weke.provider.util.*;
import com.weke.provider.vo.exam.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/upload")
    public void editorImage (@RequestParam("upload") MultipartFile file,
                               HttpServletRequest request, HttpServletResponse response){
        String uploadUrl = "null";

        try {
            if(null != file){
//                String filename = file.getOriginalFilename();
//                System.out.println(filename);
//                if(!"".equals(filename.trim())){
//                    File newFile = new File(filename);
//                    FileOutputStream os = new FileOutputStream(newFile);
//                    os.write(file.getBytes());
//                    os.close();
//                    file.transferTo(newFile);
//                    //上传到OSS 返回文件url
//                    uploadUrl = AliyunOSSUtil.upload(newFile);
//                    newFile.delete();
//
//                }
//                uploadUrl = "https://weke-video.oss-cn-beijing.aliyuncs.com/"+uploadUrl;
                uploadUrl = "https://weke-video.oss-cn-beijing.aliyuncs.com/video/2018-07-27/73ae6cda91684738b3a7d6bcddc51da8-点赞.png";
                PrintWriter out = response.getWriter();
                String callback = request.getParameter("CKEditorFuncNum");
                String str = request.getRequestURI();
                String script = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + 1 + ", '" + uploadUrl + "');</script>";
                out.println(script);
                out.flush();
                out.close();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @PostMapping("/publish")
    public String publishExam(@RequestBody ExamInfo examInfo,HttpServletRequest request) {
        try {
            System.out.println(examInfo);
            String token = request.getHeader("Authorization");
            TokenUtil tokenUtil = new TokenUtil(token);
            String userName = tokenUtil.getUserName();

            examService.insertTestInfo(examInfo,userName);
        } catch (Exception e) {
            return "false";
        }

        return "true";
    }

    /**
     * 获取题集列表
     * @return
     */
    @GetMapping("/allExam")
    public List<Exams> getAllExam(@RequestParam("userName") String userName) {
        System.out.println(userName);
        if (userName==null || userName.equals("null")) {
            return null;
        }
        System.out.println(userName.equals("null")+" "+userName.equals(""));
//        return null;
        return examService.getAllExam(userName);
    }

    /**
     * 获取考试详情
     * @param id
     * @return
     */
    @GetMapping("/examInfo")
    public List<Question> getExamInfo(@RequestParam("id") Integer id) {
        return examService.getAllQuestions(id);
    }

    /**
     * 交卷
     * @param userExamVo
     * @return
     */
    @PostMapping("/submitExam")
    public String setUserExam(@RequestBody UserExamVo userExamVo , HttpServletRequest request) {
//        try {
//            System.out.println(userExamVo);
//            examService.insertUserExam(userExamVo);
//        } catch (Exception e) {
//            return "false";
//        }
        examService.insertUserExam(userExamVo);
        return "true";
    }

    /**
     * 获取考试分析页面信息
     * @param analysis
     * @return
     */
    @PostMapping("/examAnalySis")
    public ExamExport getExamAnalysis(@RequestBody Analysis analysis) {
        System.out.println(analysis);
        return examService.getAnalysis(analysis);
    }

    /**
     * 获取答题解析页面
     * @return
     */
    @PostMapping("/getQuestions")
    public List<Question> getQuestions(@RequestBody Analysis analysis) {
        if (analysis==null) {
            return null;
        }
        if (analysis.getTestId() == null) {
            return null;
        }
        return examService.getQuestion(analysis);
    }

    /**
     * 提交改题页面信息
     * @param userExamVo
     * @return
     */
    @PostMapping("/setQuestions")
    public String setQuestions(@RequestBody UserExamVo userExamVo) {
//        System.out.println(userExamVo);
        try {
            examService.setQuestions(userExamVo);
        } catch (Exception e) {
            return "false";
        }
        return "true";
    }

    /**
     * 获取排行榜
     * @param testId
     */
    @GetMapping("/rank")
    public List<RankVo> getRank(Integer testId) {
        return examService.getRank(testId);
    }

    @Autowired
    private TestInfoRepository testInfoRepository;

    @GetMapping("/testInfo")
    public List<TestInfo> getTestInfo() {
        return testInfoRepository.findAllBy();
    }

    @Autowired
    private UserExamRepository userExamRepository;

    @Autowired
    private UserLoginUtil userLoginUtil;

    @GetMapping("/userExam")
    public String getUserExam(HttpServletRequest request) {
        String ip = IpUtil.getClinetIpByReq(request);
        String city = MyHttpResponse.cityInfo(ip);
        if (city.equals("")) {
            System.out.println("局域网");
        } else {
            System.out.println(city);
        }
//
        return city;
    }
}
