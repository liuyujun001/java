package com.example.thymeleafdemo.exception;

import com.example.thymeleafdemo.event.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    /**
     * 系统内部错误
     *
     * @return
     */
    @GetMapping("/exception")
    public Result testException() {
        int i = 1 / 0;
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData("cc");
        return result;
    }

    /**
     * 自定义异常
     *
     * @return
     */
    @GetMapping("/myException")
    public Result testMyexception() {
        throw new MyBusinessException(508, "自定义的异常");
    }

}
