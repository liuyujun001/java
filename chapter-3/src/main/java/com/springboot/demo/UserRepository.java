package com.springboot.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Query("select * from user where id=?1")
    User queryById(Long id);

}