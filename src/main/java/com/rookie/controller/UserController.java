package com.rookie.controller;

import com.rookie.pojo.User;
import com.rookie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUserList(){
        return userService.getUserList() ;
    }

    @PostMapping("/login")
    public String login(@RequestBody String username, @RequestBody String password){
        return "hello worold";
    }

    @GetMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("name", "totoro");
        return "index";
    }


}
