package com.example.springbootdemodeploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke.zhang
 * @version 1.0
 * @description: hello world
 * @date 2021/7/14 13:46
 */
@RestController
public class HelloController {
    @GetMapping("/queryUser")
    public String queryUser(@RequestParam("name")String name){
        return "/new hi "+name;
    }
}
