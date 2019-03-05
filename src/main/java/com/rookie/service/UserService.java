package com.rookie.service;

import com.rookie.pojo.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    List<String> findPermissionsByRoleId(Long roleId);

    String findRoleNameByRoleId(Long roleId);
}
