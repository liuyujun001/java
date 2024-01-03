package com.example.thymeleafdemo.exception;


import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class MyBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String message;

    public MyBusinessException(String message) {
        super(message);
        this.message = message;
    }


    public MyBusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }


}