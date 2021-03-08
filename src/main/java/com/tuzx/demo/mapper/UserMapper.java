package com.tuzx.demo.mapper;

import com.tuzx.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public String getPassword(String username);
    public void addUser(User user);
    public int verifyUsername(String username);
    public void updatePassword(User user);
    public String getUserEmail(String username);
    public User getUser(String username);
    public void updateUser(User user);

}


