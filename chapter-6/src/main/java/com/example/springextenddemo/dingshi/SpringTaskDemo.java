package com.example.springextenddemo.dingshi;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@EnableScheduling
//@Component
public class SpringTaskDemo {

    private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss");

    /**
     * 每秒钟执行一次
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public void cron() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("spring task 这是定时任务,时间是:" + pattern.format(now));
    }
}