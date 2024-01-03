package com.example.junit5demo.service;

import com.example.junit5demo.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public int countNum() {
        return productDao.countNum();
    }

    @Override
    public boolean productExists(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return productDao.productExists(name);
    }
}
