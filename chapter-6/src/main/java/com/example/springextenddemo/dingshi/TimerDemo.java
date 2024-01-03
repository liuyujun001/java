package com.example.springextenddemo.dingshi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    private static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss");

    public static void main(String[] args) {
        Timer timer = new Timer();
        /**
         * 从当前时刻开始,每1s执行一次
         */
        timer.schedule(new MyTask(),0,1000);
    }

    /**
     * 自定义任务实现
     */
    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("这是定时任务,时间是:"+pattern.format(now));
        }
    }

}
