package com.example.junit5demo.service;

import com.example.junit5demo.dao.ProductDao;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;


// 使用spring的测试框架
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductServiceImplTest {

    /**
     * 注入要测试的对象
     */
    @InjectMocks
    ProductServiceImpl productService;

    /**
     * Mock对象的依赖对象
     */
    @Mock
    ProductDao productDao;


    @BeforeEach
    public void setUp() {
        /**
         * 初始化
         */
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void coutNum() {
        /**
         * 当执行这个方法的时候直接返回5
         */
        when(productDao.countNum()).thenReturn(5);
        int num = productService.countNum();
        /**
         * 验证返回值
         */
        Assert.assertEquals(num,5);
    }

    @Test
    void productExists() {
        /**
         * 这里本来应该返回true的, 但是故意设置为false,再查看返回.
         */
        when(productDao.productExists("cc")).thenReturn(false);
        boolean cc = productService.productExists("cc");
        Assert.assertEquals(cc,false);
    }


    @Test
    void productExists3() {
        when(productDao.productExists("apple")).thenReturn(false);
        boolean cc = productService.productExists("apply");
        Assert.assertEquals(cc,false);
    }

}