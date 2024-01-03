package com.onyx.springbootdemo.contrller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api("用户模块")
@RestController
public class UserController {
    @ApiOperation("helloGet方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "名字",required = true)
    })
    @GetMapping("/helloGet")
    public String helloGet(@RequestParam("userName") @ApiParam("请求的名字") String username) {
        return "hello " + username;
    }
    @ApiOperation("helloPostJSON方法")
    @PostMapping("/helloPostJSON")
    public String helloPostJSON(@RequestBody UserVO userVO) {
        return "hello " + userVO.getUserName();
    }
}

@ApiModel(description = "用户实体类")
class UserVO {
    @ApiModelProperty("userVo的用户名")
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}