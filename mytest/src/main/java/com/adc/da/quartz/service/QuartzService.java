package com.adc.da.quartz.service;

import com.adc.da.quartz.jobs.Job_1;
import com.adc.da.quartz.jobs.Job_2;
import org.quartz.*;
import org.springframework.stereotype.Service;

@Service
public class QuartzService {

    public void jobService_1(Scheduler scheduler) throws Exception{

        //创建一个任务对象                                            设置任务名     设置任务组
        JobDetail job1 = JobBuilder.newJob(Job_1.class).withIdentity("job1", "group_job").build();

        //设置触发时间
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        //创建触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_job1", "group_job")
                .withSchedule(scheduleBuilder).build();

        //将任务和触发器配置到调度器里面
        scheduler.scheduleJob(job1,trigger);

    }

    public void jobService_2(Scheduler scheduler) throws Exception{

        //创建任务对象
        JobDetail job2 = JobBuilder.newJob(Job_2.class).withIdentity("job2", "group_job").build();

        //设置触发时间
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");

        //创建触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_job2", "group_job")
                .withSchedule(scheduleBuilder).build();

        //将任务和触发器配置到调度器里
        scheduler.scheduleJob(job2,trigger);

    }
}
