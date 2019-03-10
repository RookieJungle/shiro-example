package com.rookie.service.impl;

import com.rookie.mapper.SysRoleMapper;
import com.rookie.mapper.SysRoleUserMapper;
import com.rookie.mapper.SysUserMapper;
import com.rookie.pojo.SysRole;
import com.rookie.pojo.SysUser;
import com.rookie.pojo.SysUserExample;
import com.rookie.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public SysUserMapper userMapper;

    @Autowired
    public SysRoleMapper roleMapper;

    @Autowired
    public SysRoleUserMapper roleUserMapper;

    @Override
    public SysUser getUserByUsername(String username) {
        SysUserExample userExample=new SysUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> users = userMapper.selectByExample(userExample);
        if(CollectionUtils.isNotEmpty(users)){
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<SysUser> getUserList(){
        return userMapper.selectByExample(null);
    }

    @Override
    public Set<String> findPermissionsByRoleId(int roleId) {
        return roleMapper.findPermissionsByRoleId(roleId);
    }

    @Override
    public String findRoleNameByRoleId(int roleId) {
        return null;
    }

    @Override
    public SysRole getRoleByUserId(int id){
        return roleUserMapper.getRoleByUserId(id);
    }
}
