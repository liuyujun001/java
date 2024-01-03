package com.example.webservicesprovider.service.impl;


import com.example.webservicesprovider.service.DemoService;

import javax.jws.WebService;
import java.time.LocalDateTime;



/**
 * serviceName: 对外发布的服务名;
 * targetNamespace: 指定名称空间,一般使用接口实现类的包名的反缀;
 * endpointInterface: 服务接口的全类名;
 */
@WebService(serviceName = "DemoService"
        , targetNamespace = "http://impl.service.server.example.com"
        , endpointInterface = "com.example.webservicesprovider.service.DemoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String user) {
        return user + ",接收到了请求, 现在的时间是: " + LocalDateTime.now();
    }
}
