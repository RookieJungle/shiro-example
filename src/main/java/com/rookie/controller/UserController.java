package com.rookie.controller;

import com.rookie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUserList(){
        return "list";
    }

    @PostMapping("/login")
    public String login(){
        return "success";
    }

    @GetMapping("/error")
    public String error(Map<String, Object> map) {
        return "error";
    }


}
