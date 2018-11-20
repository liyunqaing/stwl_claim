package com.adc.da.quartz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class Task {

    public void task1(){
        System.out.println("Task_1");
    }
}
