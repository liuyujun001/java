package com.example.thymeleafdemo;

import com.example.thymeleafdemo.event.MyEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ThymeleafDemoApplication.class);
        //加入自定义的监听类
        application.addListeners(new MyEventListener());
        application.run(args);

        //SpringApplication.run(ThymeleafDemoApplication.class, args);

    }
}
