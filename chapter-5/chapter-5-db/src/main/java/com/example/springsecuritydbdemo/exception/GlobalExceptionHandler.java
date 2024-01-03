package com.example.springsecuritydbdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView exception(Exception e) {
        log.info(e.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        if (e instanceof BadCredentialsException) {
            // 密码错误
            modelAndView.addObject("msg", "密码错误");
        } else if (e instanceof AccessDeniedException) {
            // 权限不足
            modelAndView.addObject("msg", e.getMessage());
        } else {
            // 其他
            modelAndView.addObject("msg", "系统错误");
        }
        return modelAndView;
    }

}