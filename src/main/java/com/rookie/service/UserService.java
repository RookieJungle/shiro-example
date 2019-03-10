package com.rookie.service;

import com.rookie.pojo.SysRole;
import com.rookie.pojo.SysUser;

import java.util.List;
import java.util.Set;

public interface UserService {

    public List<SysUser> getUserList();

    SysUser getUserByUsername(String username);

    Set<String> findPermissionsByRoleId(int roleId);

    String findRoleNameByRoleId(int roleId);

    SysRole getRoleByUserId(int id);
}
