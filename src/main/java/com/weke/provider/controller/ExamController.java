package com.weke.provider.controller;

import com.weke.provider.mapper.ExamMapper;
import com.weke.provider.mongodb.ProblemInfo;
import com.weke.provider.mongodb.Question;
import com.weke.provider.service.ExamService;
import com.weke.provider.util.TimeUtil;
import com.weke.provider.vo.exam.Exams;
import com.weke.provider.vo.exam.ExamInfo;
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
    public String publishExam(@RequestBody ExamInfo examInfo) {
        try {
            examService.insertTestInfo(examInfo);
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
    public List<Exams> getAllExam() {
        return examService.getAllExam();
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
}
