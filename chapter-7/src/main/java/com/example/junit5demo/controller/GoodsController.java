package com.example.junit5demo.controller;


import com.example.junit5demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/queryGood")
    public String queryGood(@RequestParam("name") String name) {
        goodsService.queryGood(name);
        return "queryGood " + name;
    }

    @PostMapping("/countGood")
    public String countGood(@RequestBody Goods goods) {
        goodsService.countGood(goods.getName());
        return "countGood " + goods;
    }

}
