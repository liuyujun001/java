package com.example.springsecuritydbdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 开启security注解
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf
        http.csrf().disable();
        // 自定义登录页面
        http.formLogin()
                .loginPage("/loginPage")    // 登录页面的url
                .loginProcessingUrl("/login")// 登录访问的路径，不用自己处理逻辑只定义url即可
                .failureUrl("/exception")  // 登录失败时跳转的路径
                .defaultSuccessUrl("/index", true);  // 登录成功后跳转的路径
        // url 拦截与放行，除//loginPage、/hello、/exception、/*.jpg外的路径都拦截
        http.authorizeRequests()
                .antMatchers("/loginPage", "/hello", "/exception", "/*.jpg").permitAll()
                .anyRequest().authenticated();
        // 用户注销，
        http.logout().logoutUrl("/logout");
        // 记住密码(自动登录)
        http.rememberMe().tokenRepository(persistentTokenRepository).tokenValiditySeconds(60 * 60).userDetailsService(userDetailsService);
    }

    /**
     * 登录的友好提示
     * @return
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 显示用户找不到异常，默认不论用户名密码哪个错误都提示密码错误
        provider.setHideUserNotFoundExceptions(false);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    /**
     * 密码加密器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * 记住密码token存储
     * @param dataSource
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        // 数据存储在数据库中
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

}