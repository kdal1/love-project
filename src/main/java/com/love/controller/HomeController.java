package com.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.love.entity.LoveMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.love.entity.LoveMsg;
import com.love.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    // 首页接口，传递恋爱天数
    @GetMapping("/")
    public String home(Model model){
        long loveDays = userService.getLoveDays();
        model.addAttribute("loveDays", loveDays);
        return "index";
    }

    // 告白信页面接口
    @GetMapping("/letter")
    public String letter(){
        return "letter";
    }

    // 随机情话页面接口
    @GetMapping("/loveword")
    public String loveWord(Model model){
        LoveMsg msg = userService.getLoveWord();
        model.addAttribute("msg", msg);
        return "loveword";
    }

    // ========== 新增：专属身份卡接口 ==========
    @GetMapping("/card")
    public String card(){
        return "card";
    }

}