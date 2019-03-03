package com.rookie.service;

import com.rookie.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User getUserByName(String username,String password);
}
