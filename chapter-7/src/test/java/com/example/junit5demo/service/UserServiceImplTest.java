package com.example.junit5demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @BeforeAll
    public static void beforeAll() {
        log.info("before all");
    }

    @BeforeEach
    public void beforeEach() {
        log.info("before each");
    }

    @AfterEach
    public void afterEach() {
        log.info("after each");
    }

    @AfterAll
    public static void afterAll() {
        log.info("after all");
    }


    @Test
    void countNum() {
        int i = userService.countNum();
        assertEquals(18, i);
        assertNotEquals(1, i);
    }

    @Test
    void login() {
        boolean cc1 = userService.login("cc", "123");
        assertEquals(cc1, true);
        boolean cc2 = userService.login("cc2", "123");
        assertEquals(cc2, false);
        assertThrows(IllegalArgumentException.class, () -> userService.login("", "123"));
        assertThrows(IllegalArgumentException.class, () -> userService.login("123", null));
    }


}