package com.example.springsecuritydbdemo.service;

import com.example.springsecuritydbdemo.dao.AuthoritiesDao;
import com.example.springsecuritydbdemo.dao.UsersDao;
import com.example.springsecuritydbdemo.entity.Authorities;
import com.example.springsecuritydbdemo.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@Service("userDetailsService")
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;
    @Autowired
    private AuthoritiesDao authoritiesDao;
 
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = usersDao.findByUsername(s);
        // 用户不存在
        if (users == null) {
            log.error("用户名:[{}]不存在", s);
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 获取该用户角色信息
        Set<Authorities> authoritiesSet = authoritiesDao.findByUserId(users.getId());
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        for (Authorities authorities : authoritiesSet) {
            list.add(new SimpleGrantedAuthority(authorities.getAuthority()));
        }
        return new User(users.getUsername(), users.getPassword(), list);
    }

}