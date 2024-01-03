package com.example.thymeleafdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * 监听配置类
 */
@Configuration
@Slf4j
public class EventListenerConfig {

    @EventListener
    public void handleEvent(Object event) {
        log.info("事件：{}", event);
    }

    /**
     * 监听 code为cc的事件
     */
    @EventListener(condition = "#myCustomEvent.result.code == 'cc'")
    public void handleCustomEventByCondition(MyCustomEvent customEvent) {
        //监听 MyCustomEvent事件
        log.info("监听到code为'cc'的MyCustomEvent事件，" +
                "消息为：{}, 发布时间：{}", customEvent.getResult(), customEvent.getTimestamp());
    }

    @EventListener
    public void handleObjectEvent(Result result) {
        log.info("监听到对象事件，消息为：{}", result);
    }
}