package com.example.thymeleafdemo.event;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyEventListener  implements
        ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        Date date = new Date(event.getTimestamp());
        System.out.println("ApplicationStartingEvent事件发布,时间是:" + format.format(date));
    }

}
