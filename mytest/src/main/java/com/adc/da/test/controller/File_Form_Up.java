package com.adc.da.test.controller;

import com.adc.da.test.entity.DemoEO;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/${restPath}/test/File_Form_Up")
@Api(description = "|File_Form_Up|")
public class File_Form_Up {
    /**
    * @Description:   _通过表单实现多文件数据同时上传，方法中参数名要和前端input标签的name属性值对应
     *                  上传页面查看-stwl_claim\mytest\src\main\java\com\adc\da\test\http\form_file_up.html
    * @Author:         yueben
    * @CreateDate:     2018/11/16 15:36
    */
    @PostMapping("/up_files")
    public ResponseMessage upFiles(String username,String userpwd, MultipartFile photo, MultipartFile[] files) throws Exception{
        //获取项目根目录
        String classPath = ResourceUtils.getURL("classpath:").getPath();
        String path = classPath.substring(0,classPath.indexOf("stwl_claim")+10);

        //获取前端表单字段名并打印，方法接收的字段名要与表单的字段名对应上
        System.out.println(username);
        System.out.println(userpwd);
        //将照片存放在项目的zzz/photo下
        outFile(photo,path+"/zzz/photo");

        //将前端传入的多文件存放在项目的/zzz/word下
        for(MultipartFile mf : files){
            outFile(mf,path+"/zzz/word");
        }
        return Result.success();
    }

    //输出MultipartFile
    public void outFile(MultipartFile mtf,String path) throws Exception{
        int b;
        byte[] bytes = new byte[1024];
        //创建下载文件对象
        File file = new File(path + "/" + mtf.getOriginalFilename());
        //判断存放文件的文件夹是否存在，不存在则创建一个
        if(!file.getParentFile().exists()) file.getParentFile().mkdir();

        if(mtf != null && !mtf.isEmpty()){
            InputStream is = mtf.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);

            while((b = is.read(bytes))!=-1){
                fos.write(bytes,0,b);
            }
            is.close();
            fos.close();
        }
    }
}
