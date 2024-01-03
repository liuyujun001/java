package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileController {

    /**
     * 去文件上传的页面
     *
     * @return
     */
    @GetMapping("toUpload")
    public String toUpload() {
        return "toUpload";
    }

    /**
     * 上传一个文件
     */
    @PostMapping("/uploadFile")
    public String SingleFileUpLoad(@RequestParam("myfile") MultipartFile file,
                                   Model model) {
        //判断文件是否为空
        if (file.isEmpty()) {
            model.addAttribute("result_singlefile", "文件为空");
            return "toUpload";
        }
        //指定上传的位置为 d:/upload/
        String path = "d:/upload/";
        try {
            //获取文件的输入流
            InputStream inputStream = file.getInputStream();
            //获取上传时的文件名
            String fileName = file.getOriginalFilename();
            //注意是路径+文件名
            File targetFile = new File(path + fileName);
            //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"
            //判断文件父目录是否存在
            if (!targetFile.getParentFile().exists()) {
                //不存在就创建一个
                targetFile.getParentFile().mkdir();
            }
            //获取文件的输出流
            OutputStream outputStream = new FileOutputStream(targetFile);
            //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
            FileCopyUtils.copy(inputStream, outputStream);
            //告诉页面上传成功了
            model.addAttribute("uploadResult", "上传成功");
        } catch (Exception e) {
            model.addAttribute("uploadResult", "上传失败");
        }
        return "toUpload";
    }


}
