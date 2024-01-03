package com.example.junit5demo.service;


import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public void queryGood(String name) {
        System.out.println("执行了goods的queryGood方法,参数:" + name);
    }

    @Override
    public void countGood(String name) {
        System.out.println("执行了goods的countGood方法,参数:" + name);
    }
}
