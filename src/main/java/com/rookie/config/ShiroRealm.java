package com.rookie.config;

import com.rookie.pojo.User;
import com.rookie.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShiroRealm extends AuthorizingRealm {

    private static ApplicationContext applicationContext;

    //用于用户查询
    @Autowired
    private UserService userService;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserService userService=applicationContext.getBean(UserService.class);
        User user = (User) principals.getPrimaryPrincipal();
        List<Long> roleList = null;

        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();

        for (Long roleId : roleList) {
            List<String> permissions = userService.findPermissionsByRoleId(roleId);
            if (permissions != null) {
                for (String permission : permissions) {
                    if (StringUtils.isNotEmpty(permission)) {
                        permissionSet.add(permission);
                    }
                }
            }
            String roleName = userService.findRoleNameByRoleId(roleId);
            roleNameSet.add(roleName);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        UserService userService=applicationContext.getBean(UserService.class);
        User user = userService.getUserByUsername(token.getUsername());
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = null;
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(user, credentials, credentialsSalt, super.getName());
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName("SHA-256");
        md5CredentialsMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }
}
