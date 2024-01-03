package com.example.springbootdemodeploy.end;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
@WebEndpoint(id = "myEnd")
public class WebEndpointTest {

    /**
     * 一个read操作,所以是GET请求
     * @return  返回Map数据
     */
    @ReadOperation
    public Map<String, String> myEnd() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("name", "cc");
        result.put("age", "18");
        return result;
    }
}

