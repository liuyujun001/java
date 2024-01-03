package com.example.springsecuritydbdemo.dao;

import com.example.springsecuritydbdemo.entity.Authorities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface AuthoritiesDao {

    @Select("select a.* from authorities a LEFT JOIN users_authorities b " +
            "on a.id=b.authorities_id where b.users_id=#{userId}")
    @ResultType(Set.class)
    Set<Authorities> findByUserId(@Param("userId") Integer userId);
}
