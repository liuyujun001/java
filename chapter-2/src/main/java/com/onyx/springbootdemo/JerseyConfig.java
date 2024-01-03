package com.onyx.springbootdemo;

import com.onyx.springbootdemo.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;


@Component
@ApplicationPath("")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        //packages("com.onyx.springbootdemo.resource");
        register(UserResource.class);//register添加资源类
    }

}