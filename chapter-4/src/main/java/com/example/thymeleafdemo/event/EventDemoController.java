package com.example.thymeleafdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟触发事件
 */
@RestController
@RequestMapping("/event")
@Slf4j
public class EventDemoController {

    /**
     * 注入 事件发布类
     */
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @GetMapping("/pushObject")
    public String pushObject(@RequestParam("code") int code, @RequestParam("message") String message) {
        log.info("发布对象事件:{},{}", code, message);
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        eventPublisher.publishEvent(result);
        return "对象事件发布成功!";
    }
}