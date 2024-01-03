package com.example.junit5demo.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public int countNum() {
        return 2;
    }

    public boolean productExists(String name) {
        /**
         * 模拟dao的方法
         */
        List<String> apple = List.of("cc","apple", "orgage", "banana");
        return apple.contains(name);
    }

}
