package com.springboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userTest() {
        User user = new User();
        user.setUserName("myCc");
        user.setAge(18);
        user.setPassword("123");
        //保存用户
        userRepository.save(user);

        //根据名字查询用户
        User item = userRepository.findByUserName("myCc");
        System.out.println(item);
        Assert.assertNotNull(item);

        //id为1的用户是否存在
        Assert.assertEquals(true, userRepository.existsById(1L));

        //根据id查询用户
        Optional<User> byId = userRepository.findById(1L);
        Assert.assertEquals(true, byId.isPresent());

        Assert.assertEquals(true, userRepository.findById(2L).isPresent());

        //删除id为1的用户
        userRepository.deleteById(1L);

        //判断id为1的用户是否存在
        Assert.assertEquals(false, userRepository.existsById(1L));

    }
}