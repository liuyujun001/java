package com.example.springextenddemo.dingshi;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail testQuartz1() {
        return JobBuilder.newJob(MyQuartzTask.class).withIdentity("myQuartzTask")
                .storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger1() {
        //1秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartz1())
                .withIdentity("myQuartzTask")
                .withSchedule(scheduleBuilder)
                .build();
    }

}

