package com.adc.da.email_demo;

import com.adc.da.notify.service.NotifyService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/${restPath}/email")
public class Mailing {


    @PostMapping("/send")
    public ResponseMessage emailSend(HttpServletRequest request, HttpServletResponse response){
        String toEamil = request.getParameter("toEamil");
        String emailTitle = request.getParameter("emailTitle");
        String emailBody = request.getParameter("emailBody");
        System.out.println(toEamil + "_" + emailTitle + "_" + emailBody);
        if(toEamil != null){
            try {
                NotifyService notifyService = new NotifyService();
                notifyService.sendEmail(toEamil,emailTitle,emailBody);
                return Result.success("发送成功");
            }catch (Exception e){
                e.printStackTrace();
                Result.error("发送失败！");
            }
        }

        return Result.error("发送地址为空");
    }
}
