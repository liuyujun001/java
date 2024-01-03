package com.onyx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration //标明是一个配置配
@ComponentScan("com.onyx")
public class HelloWorld {
    //通过@Value注解, 把配置文件中的user.name注入到当前类中类.
    @Value("${user.name}")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public HelloWorld() {
        System.out.println("初始化构造器");
    }

    public void hello() {
        System.out.println("Hello: " + name);
    }
}