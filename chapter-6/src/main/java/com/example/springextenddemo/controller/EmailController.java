package com.example.springextenddemo.controller;

import com.example.springextenddemo.email.SpringEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private SpringEmailService springEmailService;

    @GetMapping("/sendEamil")
    public String sendEmail(){
        springEmailService.sendSimpleMail();
        return "send success";
    }

}
