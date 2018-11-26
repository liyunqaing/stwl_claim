package com.adc.da.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
* @Description:   _线程池配置类
* @Author:         yueben
* @CreateDate:     2018/11/23 10:06
*/
@Configuration
@EnableAsync
public class ThreadConfiguration {

    @Bean
    public Executor getExecutor(){
        ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
        //设置最小线程数
        tpte.setCorePoolSize(5);
        //设置最大线程数
        tpte.setMaxPoolSize(10);
        //设置等待队列长
        tpte.setQueueCapacity(25);

        tpte.initialize();

        return tpte;
    }
}
