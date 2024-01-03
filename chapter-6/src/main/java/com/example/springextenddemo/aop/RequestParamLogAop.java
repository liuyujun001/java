package com.example.springextenddemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletResponseWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * 第一个执行
 */
@Order(1)
/**
 * aspect 切面
 */
@Aspect
@Component
public class RequestParamLogAop {

    private static final Logger log = LoggerFactory.getLogger(RequestParamLogAop.class);

    /**
     * Controller层切点
     */
    @Pointcut("execution (* com.example.springextenddemo.controller..*.*(..))")
    public void controllerAspect() {
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around(value = "controllerAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        methodBefore(joinPoint,signature);
        Object result = joinPoint.proceed();
        methodAfterReturn(result, signature);
        return result;
    }

    /**
     * 方法执行前执行
     *
     * @param joinPoint
     * @param signature
     */
    private void methodBefore(JoinPoint joinPoint, Signature signature) {
        //两个数组中，参数值和参数名的个数和位置是一一对应的。
        Object[] objs = joinPoint.getArgs();
        // 参数名
        String[] argNames = ((MethodSignature) signature).getParameterNames();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < objs.length; i++) {
            if (!(objs[i] instanceof ExtendedServletRequestDataBinder)
                    && !(objs[i] instanceof HttpServletResponseWrapper)) {
                paramMap.put(argNames[i], objs[i]);
            }
        }
        log.info("请求前-方法:{} 的请求参数:{}", signature, paramMap);
    }

    /**
     * 方法执行后的返回值
     */
    private void methodAfterReturn(Object result, Signature signature) {
        log.info("请求后-方法:{} 的返回参数是:{}", signature, result);
    }


}
