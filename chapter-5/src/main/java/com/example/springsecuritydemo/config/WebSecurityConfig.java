package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.service.LoginSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf的校验
        http.csrf().disable();
        // 配置登录页面, 用户名和密码在配置文件中了
        http.formLogin().loginPage("/login").permitAll();
        // 配置登录成功后的操作
        http.formLogin().successHandler(new LoginSuccessHandler());
        // 登出授权
        http.logout().permitAll();
        // 授权配置
        http.authorizeRequests()
                 //所有静态文件可以访问
                .antMatchers("/js/**","/css/**","/images/**").permitAll()
                // 所有 以/add 开头的 add页面可以访问
                .antMatchers("/add/**").permitAll()
                .antMatchers("/home2").hasRole("user")
                .anyRequest().fullyAuthenticated();
    }



    /**
     * 授权，赋予用户角色, 基于内存，授权
     */
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("123456").roles("admin").build());
        return manager;
    }
}

