package com.rookie.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;

@Slf4j
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));
        Object accountCredentials = getCredentials(info);
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
        return equals(tokenCredentials, accountCredentials);
    }

    //将传进来密码加密方法
    private String encrypt(String data) {
        String sha384Hex = new Sha384Hash(data).toBase64();
        log.info(data + ":" + sha384Hex);
        return sha384Hex;
    }

}
