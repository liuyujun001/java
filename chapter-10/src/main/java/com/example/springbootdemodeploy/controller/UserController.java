package com.example.springbootdemodeploy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/hi")
    public String queryUser(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", "hi " + name);
        return "hi";
    }
}
