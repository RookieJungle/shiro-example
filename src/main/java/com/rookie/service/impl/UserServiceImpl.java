package com.rookie.service.impl;

import com.rookie.mapper.UserMapper;
import com.rookie.pojo.User;
import com.rookie.pojo.UserExample;
import com.rookie.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User getUserByName(String username, String password) {

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(CollectionUtils.isNotEmpty(users)){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(CollectionUtils.isNotEmpty(users)){
            return users.get(0);
        }
        return null;
    }
}
