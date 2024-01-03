package com.springboot.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class ValidateCommonHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        ResponeVo vo = new ResponeVo();
        vo.setCode(500);
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String defaultMessage = fieldError.getDefaultMessage();
            vo.setMessage(defaultMessage);
            Object value = fieldError.getRejectedValue();
            vo.setData(value);
            break;
        }
        return new ResponseEntity(vo, HttpStatus.OK);
    }
}