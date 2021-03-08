package com.tuzx.demo.service.impl;

import com.tuzx.demo.mapper.UserMapper;
import com.tuzx.demo.pojo.User;
import com.tuzx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public int verifyUsername(String username) {
        return userMapper.verifyUsername(username);
    }

    @Override
    public void updatePassword(User user) {
        userMapper.updatePassword(user);
    }

    @Override
    public String getUserEmail(String username) {
        return userMapper.getUserEmail(username);
    }

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
