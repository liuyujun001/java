package com.example.junit5demo.service;

/**
 * 测试实现
 */

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Override
    public boolean login(String userName, String password) throws IllegalArgumentException {
        if (userName == null || password == null
                || userName.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("不能为空");
        }
        if ("cc".equals(userName) && "123".equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public int countNum() {
        return 18;
    }

}
