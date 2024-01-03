package com.example.thymeleafdemo.event;

import org.springframework.context.ApplicationEvent;

public class MyCustomEvent extends ApplicationEvent {

    private Result result;

    public MyCustomEvent(Object source, Result result) {
        super(source);
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }
}