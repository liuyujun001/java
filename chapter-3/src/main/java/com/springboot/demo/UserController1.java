package com.springboot.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController1 {

    /**
     * 保存新的用户
     * @param user
     */
    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        if (user.getAge() > 120) {
            throw new IllegalArgumentException("最大年龄小于120");
        }
        if (user.getAge() < 1) {
            throw new IllegalArgumentException("最小年龄大于1");
        }
        if (user.getUserName() == null) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (user.getUserName().length() > 10) {
            throw new IllegalArgumentException("用户名长度不能超过10");
        }
        if(user.getPassword()==null){
            throw new IllegalArgumentException("密码不能为空");
        }
        //TODO saveTheUser
    }
}
