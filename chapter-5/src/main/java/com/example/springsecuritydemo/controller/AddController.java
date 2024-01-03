package com.example.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {

    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @GetMapping("/add2")
    public String add2(){
        return "add2";
    }
}
