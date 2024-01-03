package com.example.springextenddemo.dingshi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss");

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("schedule 这是定时任务,时间是:" + pattern.format(now));
        }, 0, 1000, TimeUnit.MILLISECONDS);

    }

}
