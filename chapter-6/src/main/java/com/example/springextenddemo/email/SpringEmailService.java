package com.example.springextenddemo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SpringEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 注入发件人的邮箱地址
     */
    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Spring 邮件发送");
        message.setFrom(from);
        message.setTo("1507775353@qq.com");
        message.setSentDate(new Date());
        message.setText("这是使用Spring发送邮件");
        javaMailSender.send(message);
    }

}
