package com.onyx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {

        //使用配置文件初始化一个spring的ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);
        //根据HelloWord的类找到bean实例
  //      HelloWorld bean = context.getBean(HelloWorld.class);
        //调用bean的方法,验证注入属性是否成功
//        bean.hello();

        //通过name获取
        HelloWorld contextBean = (HelloWorld)context.getBean("helloWorld");
        contextBean.hello();
    }
}
