package com.adc.da.quartz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description:   _单任务实现类
* @Author:         yueben
* @CreateDate:     2018/11/20 21:00
*/
@Configuration
@EnableScheduling
public class Task {

    public void task1(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
