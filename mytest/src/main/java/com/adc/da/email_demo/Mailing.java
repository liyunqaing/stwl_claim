package com.adc.da.email_demo;


import com.adc.da.notify.service.NotifyService;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
@RequestMapping("/${restPath}/email")
public class Mailing {

    @Autowired
    private NotifyService notifyService;

    /**
     * @Description: _邮件发送，在配置文件中写入发送方邮件的账号密码，密码是邮箱的POP3/SMTP的授权码
     * @Author: yueben
     * @CreateDate: 2018/11/19 14:48
     */
    @PostMapping("/send")
    public ResponseMessage emailSend(String toEmail, String emailTitle, String emailBody, MultipartFile emailFile) throws Exception {
        System.out.println(toEmail + "_" + emailTitle + "_" + emailBody + "_" + emailFile);

        //获取项目根目录
        String classPath = ResourceUtils.getURL("classpath:").getPath();
        String path = classPath.substring(0, classPath.indexOf("stwl_claim") + 10);

        //判断获取的邮箱账号是否为空
        if (toEmail != null) {
            //判断附件是否存在
            if (!emailFile.isEmpty()) {
                File file = new File(path + "/zzz/atta/" + emailFile.getOriginalFilename());
                //判断存放文件的文件夹是否存在，不存在则创建一个
                if (!file.getParentFile().exists()) file.getParentFile().mkdir();
                //获取附件输出流
                InputStream is = emailFile.getInputStream();
                FileOutputStream fos = new FileOutputStream(file);
                //将附件写出
                int b;
                byte[] bytes = new byte[1024];
                while ((b = is.read(bytes)) != -1) {
                    fos.write(bytes, 0, b);
                }
                fos.close();
                is.close();
                if (!file.exists()) return Result.error("附件上传失败");
                try {
                    notifyService.sendMultiEmail(toEmail, emailTitle, emailBody, file);
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.error("发送失败!!!");
                }
                return Result.success("发送成功!!!");

            } else {
                try {
                    //发送邮件
                    notifyService.sendEmail(toEmail, emailTitle, emailBody);
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.error("发送失败!!!");
                }
                return Result.success("发送成功!!!");
            }
        }

        return Result.error("发送失败!!!");
    }

}
