package com.library.service.impl;

import com.library.entity.Account;
import com.library.mapper.UserMapper;
import com.library.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = mapper.findUserByUsername(username);
        if (account == null)
            throw new UsernameNotFoundException("Username or Password wrong");

        return User.withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

}
