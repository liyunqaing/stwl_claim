package com.adc.da.fyxTest.util;

import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.UUID;

/**
 * @program: stwl_claim2
 * @description: 上传文件工具
 * @author: cuiyuxin
 * @create: 2018-11-20 09:20
 * @version: 2.0.0
 **/
public class FileUpload {

    //保存地址文件夹名称
    private static  String savePicPath;

    /**
     * @Description:  初始化
     * @Param: []
     * @return:
     * @Author: cuiyuxin
     * @Date: 2018/11/14
     */
    public FileUpload(String savePicPath) {
        this.savePicPath=savePicPath;
    }
    /**
     * @Description: 上传文件并计时
     * @Param: [file, request]
     * @return: void
     * @Author: cuiyuxin
     * @Date: 2018/11/14
     */
    public static  void FileUploadFIle(MultipartFile file,HttpServletRequest request) throws IOException {
        long startTime=System.currentTimeMillis();//记录开始时间

        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = savePicPath + "/"; // 设定文件保存的目录

        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime=System.currentTimeMillis();//记录结束时间

        float excTime=(float)(endTime-startTime)/1000;

        System.out.println("执行时间："+excTime+"s");
    }

    /**
     * @Description: 上传文件并计时 优化方案
     * @Param: [file, request]
     * @return: void
     * @Author: cuiyuxin
     * @Date: 2018/11/14
     */
    /*public static  void FileUploadFIle2(CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        long startTime=System.currentTimeMillis();//记录开始时间

        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = savePicPath + "/"; // 设定文件保存的目录

        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileInputStream in = (FileInputStream) file.getInputStream();
                FileOutputStream fos = new FileOutputStream(path + newFileName);

                *//*int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }*//*
                FileChannel fcIn = in.getChannel();
                FileChannel fcOut = fos.getChannel();
                //提升
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (true) {
                    buffer.clear();
                    int r = fcIn.read(buffer);
                    if (r == -1) {
                        break;
                    }
                    buffer.flip();
                    fcOut.write(buffer);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime=System.currentTimeMillis();//记录结束时间

        float excTime=(float)(endTime-startTime)/1000;

        System.out.println("执行时间："+excTime+"s");
    }*/
}
