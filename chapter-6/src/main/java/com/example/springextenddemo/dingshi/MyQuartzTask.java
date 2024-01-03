package com.example.springextenddemo.dingshi;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MyQuartzTask extends QuartzJobBean{

    private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss");

    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("quartz 这是定时任务,时间是:" + pattern.format(now));
    }
}

