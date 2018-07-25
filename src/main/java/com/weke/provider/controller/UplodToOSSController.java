//package com.weke.provider.controller;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//import javax.servlet.http.*;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.*;
//
//public class UplodToOSSController {
//    /**
//     * 方法描述:文件上传
//     *
//     * @param request
//     * @param response
//     * @return
//     * @author leon 2017年7月25日 上午10:54:37
//     */
//    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
//    @ResponseBody
//    public ResultModel<List<String>> upload(HttpServletRequest request, HttpServletResponse response) {
//        ResultModel<List<String>> resultModel = new ResultModel<List<String>>();
//        try {
//
//            // 创建一个通用的多部分解析器
//            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//            List<String> files = new ArrayList<>();
//            // 判断 request 是否有文件上传,即多部分请求
//            if (multipartResolver.isMultipart(request)) {
//                // 转换成多部分request
//                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//                // 取得request中的所有文件名
//                Iterator<String> iter = multiRequest.getFileNames();
//                while (iter.hasNext()) {
//                    // 取得上传文件
//                    MultipartFile file = multiRequest.getFile(iter.next());
//                    if (file != null) {
//                        // 取得当前上传文件的文件名称
//                        String fileName = file.getOriginalFilename();
//                        // 如果名称不为空,说明该文件存在，否则说明该文件不存在
//                        if (fileName.trim() != "") {
//                            File newFile = new File(fileName);
//                            FileOutputStream outStream = new FileOutputStream(newFile); // 文件输出流用于将数据写入文件
//                            outStream.write(file.getBytes());
//                            outStream.close(); // 关闭文件输出流
//                            file.transferTo(newFile);
//                            // 上传到阿里云
//                            files.add(AliOSSUtil.upload(newFile));
//                            newFile.delete();
//                        }
//                    }
//                }
//            }
//
//            resultModel.setReturnValue(files);
//        } catch (ValidateException e) {
//            resultModel.setSuccessed(false);
//            resultModel.setErrorCode(e.getMessage());
//        } catch (Exception e) {
//            resultModel.setSuccessed(false);
//            resultModel.setErrorCode("system error");
//            log.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return resultModel;
//    }
//
//}
