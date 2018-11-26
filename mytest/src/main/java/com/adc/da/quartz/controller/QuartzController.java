package com.adc.da.quartz.controller;

import com.adc.da.quartz.service.QuartzService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import javax.annotation.Resource;

/**
* @Description:   _通过接口来改变定时器（触发器）时间
* @Author:         yueben
* @CreateDate:     2018/11/20 14:54
*/
@RestController
@RequestMapping("/${restPath}/quartz")
public class QuartzController {

    private static final Logger logger = LoggerFactory.getLogger(QuartzController.class);

    @Resource(name = "jobTask1")
    private JobDetail jobTask1;

    @Resource(name = "taskTrigger")
    private CronTrigger taskTrigger;

    @Resource(name = "schedulerTask")
    private Scheduler scheduler;

    @Resource(name = "tasksSch")
    private Scheduler tasksSch;

    @Autowired
    private QuartzService quartzService;


    @GetMapping("/task_1")
    public ResponseMessage task_1() throws Exception{
        //获取触发器
        CronTrigger trigger = (CronTrigger)scheduler.getTrigger(taskTrigger.getKey());

        //获取当前触发器的触发时间
        String currentCron = trigger.getCronExpression();
        System.out.println("当前trigger正在使用的—" + currentCron);

        //设置触发时间
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/7 * * * * ?");

        //重构trigger
        trigger = trigger.getTriggerBuilder().withIdentity(taskTrigger.getKey()).withSchedule(scheduleBuilder).build();

        //使用新trigger执行任务
        scheduler.rescheduleJob(taskTrigger.getKey(),trigger);


        return Result.success("task_1的触发时间:");
    }

    @GetMapping("/job/job_1")
    public ResponseMessage job_1(){
        try {
            quartzService.jobService_1(tasksSch);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("job_1定时器启动失败");
        }
        return Result.success("job_1定时器启动成功");
    }

    @GetMapping("/job/job_2")
    public ResponseMessage job_2(){
        try {
            quartzService.jobService_2(tasksSch);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("job_2定时器启动失败");
        }
        return Result.success("job_2定时器启动成功");
    }



}
