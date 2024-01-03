package com.example.springsecuritydbdemo.dao;

import com.example.springsecuritydbdemo.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersDao {

    @Select("select * from users where username=#{username}")
    Users findByUsername(@Param("username") String username);

    void save(Users users);
}
