package com.wusd.readinglist;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * UserDetail: 代表Spring Security里的用户
 */
@Entity
public class Reader implements UserDetails {

    private static final long serialVersionUID = 1L;

    // reader字段
    @Id
    private String username;
    private String fullname;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 授予READER权限
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 不过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 不加锁
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 不会撤销
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 不禁用
        return true;
    }
}
