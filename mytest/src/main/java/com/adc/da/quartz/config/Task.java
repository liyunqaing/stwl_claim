package com.adc.da.quartz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
* @Description:   _单任务实现类
* @Author:         yueben
* @CreateDate:     2018/11/20 21:00
*/
@Configuration
@EnableScheduling
public class Task {

    public void task1(){
        System.out.println("Task_1");
    }
}
