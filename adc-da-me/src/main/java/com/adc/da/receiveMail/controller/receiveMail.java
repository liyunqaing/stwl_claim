package com.adc.da.receiveMail.controller;

import com.adc.da.notify.service.NotifyService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/${restPath}/student/student")
@Api(description = "|StudentEO|")
public class receiveMail {
    @Autowired
    private NotifyService notifyService;

    @ApiOperation(value = "|StudentVO1|邮件发送")
    @PostMapping("/sendEmail")
    @RequiresPermissions("student:student:Mails")
//    @PostMapping("/sendEmail")
    public ResponseMessage<Object> sendEmail(HttpServletResponse response, HttpServletRequest request) {
//        数据测试
//        String toEmail = "764441447@qq.com";
//        String emailTitle = "你好";
//        String content = "helle world";

        String toEmail=request.getParameter("toEmail");
        String emailTitle=request.getParameter("emailTitle");
        String content=request.getParameter("content");


        if(toEmail!=null) {
            try {
                notifyService.sendEmail(toEmail,emailTitle, content);

            }catch (Exception e) {
                e.printStackTrace();
                return Result.error("对方邮件地址是-》" + toEmail + " 内容是-》 " + content);
            }
        }
        return Result.success();
    }
}