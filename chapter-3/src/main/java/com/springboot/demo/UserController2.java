package com.springboot.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController2 {

    /**
     * 保存新的用户
     * @param user
     */
    @PostMapping("/save2")
    public void saveUser(@Valid @RequestBody User user) {
        //TODO saveTheUser
    }

}
