package com.example.thymeleafdemo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * 自定义拦截器的实现
 */
@Component
public class MyHttpFilter implements Filter {

    /**
     * 拦截方法
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String requestURI = servletRequest.getRequestURI();
        if ("/test1".equals(requestURI)) {
            Map<String, String[]> map = servletRequest.getParameterMap();
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                System.out.println("请求的参数名字是：" + entry.getKey()
                        + " ,请求的值是：" + Arrays.toString(entry.getValue()));
                return;
            }
        }
        //放行，继续业务方面的处理。
        chain.doFilter(servletRequest,response);
    }

}
