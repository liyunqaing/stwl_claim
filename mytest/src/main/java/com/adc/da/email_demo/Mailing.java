package com.adc.da.email_demo;


import com.adc.da.notify.service.NotifyService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${restPath}/email")
public class Mailing {

    @Autowired
    private NotifyService notifyService;

    /**
    * @Description:   _邮件发送，在配置文件中写入发送方邮件的账号密码，密码是邮箱的POP3/SMTP的授权码
    * @Author:         yueben
    * @CreateDate:     2018/11/19 14:48
    */
    @PostMapping("/send")
    public ResponseMessage emailSend(@RequestBody EmailEo  emailEo){
        System.out.println(emailEo.getToEamil() + "_" + emailEo.getEmailTitle() + "_" + emailEo.getEmailBody());
        //判断获取的邮箱账号是否为空
        if(emailEo.getToEamil() != null){
            try {
                //发送邮件
                notifyService.sendEmail(emailEo.getToEamil(),emailEo.getEmailTitle(),emailEo.getEmailBody());
            }catch (Exception e){
                e.printStackTrace();
                return Result.error("发送失败!!!");
            }
        }

        return Result.success("发送成功!!!");
    }
}
