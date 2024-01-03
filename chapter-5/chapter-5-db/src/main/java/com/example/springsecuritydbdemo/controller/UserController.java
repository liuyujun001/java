package com.example.springsecuritydbdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class UserController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/loginPage")
    public String login() {
        return "login";
    }


    /**
     * security 认证异常处理
     */
    @GetMapping("/exception")
    public String error(HttpServletRequest request) {
        // 获取spring security的AuthenticationException异常并抛出，由全局异常统一处理
        AuthenticationException exception = (AuthenticationException) WebUtils.getSessionAttribute(request, "SPRING_SECURITY_LAST_EXCEPTION");
        if (exception != null) {
            throw exception;
        }
        return "redirect:/loginPage";
    }

    @GetMapping({"/index", "/"})
    public String index() {
        return "index";
    }


    @ResponseBody
    @GetMapping("/role/teacher")
    @Secured({"ROLE_teacher", "ROLE_admin"})
    public String teacher() {
        return "模拟获取老师数据";
    }

    @ResponseBody
    @GetMapping("/role/admin")
    @Secured({"ROLE_admin"})
    public String admin() {
        return "模拟获取管理员数据";
    }

    @ResponseBody
    @GetMapping("/role/student")
    @Secured({"ROLE_student", "ROLE_admin"})
    public String student() {
        return "模拟获取学生数据";
    }
}