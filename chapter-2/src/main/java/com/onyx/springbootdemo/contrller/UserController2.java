package com.onyx.springbootdemo.contrller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    @GetMapping("/helloGet")
    public String helloGet(@RequestParam("userName") String username) {
        return "hello " + username;
    }

    @PostMapping("/helloPostForm")
    public String helloPostForm(@RequestParam("userName") String username) {
        return "hello " + username;
    }

    @PostMapping("/helloPostJson")
    public String helloPostJson(@RequestBody UserVO userVO) {
        return "hello " + userVO.getUserName();
    }

    @PutMapping("/helloPut")
    public String helloPut(@RequestBody UserVO userVO) {
        return "hello " + userVO.getUserName();
    }

}
