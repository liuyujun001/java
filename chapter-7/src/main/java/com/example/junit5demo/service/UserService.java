package com.example.junit5demo.service;


import java.util.IllegalFormatException;

/**
 * 测试接口
 */
public interface UserService {

    /**
     * 登陆
     * @param userName
     * @param password
     * @return
     * @throws IllegalFormatException
     */
    boolean login(String userName,String password) throws IllegalFormatException;

    /**
     * 查询数量
     * @return
     */
    int countNum();

}
