package com.adc.da.quartz.config;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
* @Description:   _Quartz配置类
 *                 _实现类单任务定时器，实现的是Task类下的方法
 *                 _配置了对多任务调度器
* @Author:         yueben
* @CreateDate:     2018/11/20 13:20
*/
@Configuration
public class QuartzConfigration {

    /**
    * @Description:   _配置任务
    * @Author:         yueben
    * @CreateDate:     2018/11/20 13:41
    */
    @Bean(name =  "jobTask1")
    public MethodInvokingJobDetailFactoryBean task1factoryBean(Task task){
        //创建一个任务对象
        MethodInvokingJobDetailFactoryBean jobBean = new MethodInvokingJobDetailFactoryBean();

        //设置是否并发执行，true为并发执行，设置为false时上一个任务执行完毕才能开始下一个
        jobBean.setConcurrent(true);

        //设置任务名称
        jobBean.setName("task_1");

        //设置任务分组
        jobBean.setGroup("task");

        //将要执行的方法放入任务里
        jobBean.setTargetObject(task);     //将Task类添加到任务里
        jobBean.setTargetMethod("task1");  //task类中的方法名

        return jobBean;

    }

    /**
    * @Description:   _配置触发器
    * @Author:         yueben
    * @CreateDate:     2018/11/20 13:41
    */
    @Bean(name = "taskTrigger")
    public CronTriggerFactoryBean taskTrigger(MethodInvokingJobDetailFactoryBean jobTask1){
        //创建触发器对象
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

        //给触发器绑定一个任务
        trigger.setJobDetail(jobTask1.getObject());

        //设置执行周期
        trigger.setCronExpression("0/6 * * * * ?");     //每六秒执行一次

        //设置触发器名称
        trigger.setName("taskTrigger");

        return trigger;
    }

    /**
    * @Description:   _配置调度器
    * @Author:         yueben
    * @CreateDate:     2018/11/20 13:51
    */
    @Bean(name = "schedulerTask")
    public SchedulerFactoryBean schedulerTask(Trigger trigger){
        //创建调度器对象
        SchedulerFactoryBean bean = new SchedulerFactoryBean();

        //设置已定义的任务是否覆盖现有的任务，默认为false，即已定义任务不会覆盖现有任务
        bean.setOverwriteExistingJobs(true);

        //设置延时启动触发器
        bean.setStartupDelay(5);    //应用启动五秒后，在启动触发器

        //添加触发器
        bean.setTriggers(trigger);

        return bean;
    }

    /**
    * @Description:   _多任务调度器配置
    * @Author:         yueben
    * @CreateDate:     2018/11/20 15:11
    */
    @Bean(name = "tasksSch")
    public SchedulerFactoryBean tasksSch(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        return bean;
    }

}
