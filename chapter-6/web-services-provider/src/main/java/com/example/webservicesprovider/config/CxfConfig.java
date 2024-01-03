package com.example.webservicesprovider.config;


import com.example.webservicesprovider.service.DemoService;
import com.example.webservicesprovider.service.impl.DemoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


@Configuration
public class CxfConfig {

    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        /**
         * ServletRegistrationBean是Servlet注册类,
         * 参数1为Servlet对象,参数2为请求到Servlet的地址
         */
        return new ServletRegistrationBean<>(new CXFServlet(), "/demo/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * 类的注册
     * @return
     */
    @Bean
    public DemoService demoService() {
        return new DemoServiceImpl();
    }

    /**
     * 发布多个服务时,创建多个,并使用@Qualifier指定不同的名称
     * @return
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoService());
        endpoint.publish("/api");
        return endpoint;

    }
}
