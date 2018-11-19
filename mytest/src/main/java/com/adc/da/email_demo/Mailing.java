package com.adc.da.email_demo;


import com.adc.da.notify.service.NotifyService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${restPath}/email")
public class Mailing {


    @PostMapping("/send")
    public ResponseMessage emailSend(@RequestBody EmailEo  emailEo){

        System.out.println(emailEo.getToEamil() + "_" + emailEo.getEmailTitle() + "_" + emailEo.getEmailBody());
        if(emailEo.getToEamil() != null){
            try {
                NotifyService notifyService = new NotifyService();
                notifyService.sendEmail(emailEo.getToEamil(),emailEo.getEmailTitle(),emailEo.getEmailBody());
            }catch (Exception e){
                e.printStackTrace();
                return Result.error("发送失败!!!");
            }
        }

        return Result.success("发送成功!!!");
    }
}
