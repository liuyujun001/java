package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("title","i miss CC very much");
        return "user/addUser";
    }


    @ResponseBody
    @GetMapping("/test1")
    public String test1(){
        return "success";
    }


}
