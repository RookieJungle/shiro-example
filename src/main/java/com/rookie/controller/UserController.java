package com.rookie.controller;

import com.rookie.pojo.SysUser;
import com.rookie.service.UserService;
import com.rookie.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/user")
    public List<SysUser> getUserList(){
        return userService.getUserList();
    }

    @PostMapping("/login")
    public String login(HttpServletResponse response,String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        subject.login(usernamePasswordToken);

        SysUser user = (SysUser) subject.getPrincipal();

        String token = JwtUtils.sign(username, user.getSalt(), 60 * 5);//生成jwt token，设置过期时间为1分钟

        redisTemplate.opsForValue().set(token, user);

        response.setHeader("x-auth-token", token);
        return "ok";
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping(value = "/logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
