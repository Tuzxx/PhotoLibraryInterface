package com.tuzx.demo.service;

import com.tuzx.demo.pojo.User;

public interface UserService {
    public String getPassword(String username);
    public void addUser(User user);
    public int verifyUsername(String username);
    public void updatePassword(User user);
    public String getUserEmail(String username);
    public User getUser(String username);
    public void updateUser(User user);
}
