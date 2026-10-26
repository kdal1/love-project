package com.love.controller;

import com.love.entity.LoveMsg;
import com.love.entity.User;
import com.love.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/love")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/mylove")
    public User test(){
        return userService.getMyGirlFriend();
    }

    @GetMapping("/word")
    public LoveMsg loveMessage(){
        return userService.getLetter();
    }

    @GetMapping("/days")
    public Map<String,Object> loveDays(){
        Map<String,Object> res = new HashMap<>();
        res.put("tip","我们在一起的天数");
        res.put("days", userService.getLoveDays());
        res.put("message","朝朝暮暮，岁岁相伴💌");
        return res;
    }

    @GetMapping("/sweet")
    public Map<String,Object> sweetTalk(){
        Map<String,Object> res = new HashMap<>();
        res.put("tip","今日情话");
        res.put("content", userService.getLoveWord());
        return res;
    }
}