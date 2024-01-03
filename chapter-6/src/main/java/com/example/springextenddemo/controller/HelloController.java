package com.example.springextenddemo.controller;

import com.example.springextenddemo.vo.UserVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String hi(@RequestParam("name")String name){
        return "hi "+name;
    }

    @PostMapping("/hi-post")
    public String hiPost(@RequestBody UserVO userVO){
        return "hi-post "+userVO;
    }

}
