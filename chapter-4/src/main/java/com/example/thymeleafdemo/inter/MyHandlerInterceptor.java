package com.example.thymeleafdemo.inter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * 自定义拦截器
 */
@Slf4j
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {

    /**
     * 在业务代码处理之前, 进行参数的记录
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器: preHandle 在控制器的处理请求方法调用之后，解析视图之前执行");
        String requestURI = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(Arrays.toString(entry.getValue()));
            sb.append(",");
        }
        log.info("拦截器: 请求的url是:{},请求的参数是:{}",requestURI,sb.toString());
        return true;
    }

    /**
     * 在业务代码处理之后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器: postHandle方法在控制器的处理请求方法调用之后，解析视图之前执行");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("拦截器: afterCompletion方法在控制器的处理请求方法执行完成后执行，" +
                "即视图渲染结束之后执行");
    }
}
