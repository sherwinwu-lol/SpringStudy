package com.wusd.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * SpringBootWebSecurityConfiguration的ConditionOnMissBean（WebSecurityConfigurerAdapter）
 * 当WebSecurityConfigurerAdapter存在时, 就跳过自动配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // "/"的请求
                .antMatchers("/")
                // 要求登录者有READER角色
                .access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                // 设置登录表单的路径
                .formLogin()
                // 登录页和登录失败页都指定到了/login
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }

    /**
     * 这个服务可以任意实现了UserDetailService的类
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 用于查找指定用户名的用户
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return readerRepository.getOne(username);
            }
        });
    }
}
