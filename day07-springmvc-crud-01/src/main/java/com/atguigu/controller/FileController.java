package com.atguigu.controller;

import com.atguigu.result.Result;
import com.atguigu.utils.FileUtils;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ServletContext servletContext;
    /*
    @RequestParam
    Annotation which indicates that a method parameter should be bound to a web request parameter.
    Supported for annotated handler methods in Spring MVC and Spring WebFlux as follows:
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        //将客户端上传的文件保存到部署的当前项目的uploads文件夹中
        //1. 获取用户上传的文件的文件名
        String originalFilename = file.getOriginalFilename();
        //2. 将文件名转成一个不会重复的文件名(保证文件的后缀不变)
        String uuidFileName = FileUtils.getFileName(originalFilename);
        //3. 获取存储文件的目录
        //3.1 获取两级目录(随机生成的目录或者按照日期生成的目录)
        //2.1 获取部署的当前项目的根目录下的uploads目录
        //访问时候的目录路径
        String dirName = "uploads" + FileUtils.getRandomDirName();

        //从servletContext获取真实路径
        String uploadDir = servletContext.getRealPath(dirName);
        //2.2 判断当前目录是否存在
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()){
            //如果不存在，则创建
        uploadDirFile.mkdir();
        }
        //3. 保存文件
        file.transferTo(new File(uploadDirFile,uuidFileName));

        //4. 获取文件的访问路径
        String url = "http://localhost:8080/"+dirName+"/" +uuidFileName;

        return Result.ok(url);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName) throws IOException {
        //1. 直接使用ServletContext获取文件的输入流
        //调用的是webapp下的downloadFiles文件夹
        InputStream inputStream = servletContext.getResourceAsStream("downloadFiles/" + fileName);
        //2. 使用字节数组读取输入流中的数据
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        //3. 将字节数组封装成ResponseEntity对象,ok方法是设置响应状态码为200
        //并且要设置响应头:Content-Type 表示当前下载的文件的媒体类型(MIME-TYPE),我们可以使用ServletContext根据文件名获取文件的媒体类型
        String mimeType = servletContext.getMimeType(fileName);
        //判断如果mimeType包含text,就在后面添加;charset=utf-8
        if (mimeType.contains("text")){
             mimeType = mimeType + ";charset=utf-8";
        }

        return ResponseEntity.ok()
                .header("Content-Type",mimeType) //这个响应头表示当前下载的文件的媒体类型
                .header("Content-Dispostion","attachment;filename=" +fileName)//这个响应头表示要让客户端以附件的形式下载文件
                .body(buffer);

    }
}
