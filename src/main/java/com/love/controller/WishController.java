package com.love.controller;

import com.love.entity.Wish;
import com.love.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/wish")
public class WishController {

    @Autowired
    private WishRepository wishRepo;

    // 心愿列表页面
    @GetMapping("/list")
    public String wishList(Model model){
        List<Wish> wishList = wishRepo.findAll();
        model.addAttribute("wishList", wishList);
        return "wish/list";
    }

    // 添加心愿
    @PostMapping("/add")
    public String addWish(@RequestParam String content){
        Wish wish = new Wish();
        wish.setContent(content);
        wish.setFinished(false);
        wish.setCreateTime(java.time.LocalDateTime.now());
        wishRepo.save(wish);
        return "redirect:/wish/list";
    }

    // 切换完成状态（勾选/取消勾选）
    @PostMapping("/toggle")
    public String toggleWish(@RequestParam Long id){
        Wish wish = wishRepo.findById(id).orElse(null);
        if(wish != null){
            wish.setFinished(!wish.getFinished());
            wishRepo.save(wish);
        }
        return "redirect:/wish/list";
    }

    // 删除心愿
    @PostMapping("/delete")
    public String deleteWish(@RequestParam Long id){
        wishRepo.deleteById(id);
        return "redirect:/wish/list";
    }
}