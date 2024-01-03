package com.example.springsecuritydbdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@MapperScan("com.example.springsecuritydbdemo.dao")
@EnableWebSecurity
@SpringBootApplication
public class SpringSecurityDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDbDemoApplication.class, args);
    }

}
