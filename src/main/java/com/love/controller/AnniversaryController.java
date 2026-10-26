package com.love.controller;

import com.love.entity.Anniversary;
import com.love.repository.AnniversaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/anniversary")
public class AnniversaryController {

    @Autowired
    private AnniversaryRepository annRepo;

    @GetMapping("/list")
    public String list(Model model){
        List<Anniversary> list = annRepo.findAll();
        List<Map<String,Object>> annVoList = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for(Anniversary ann : list){
            Map<String,Object> map = new HashMap<>();
            map.put("id",ann.getId());
            map.put("name",ann.getName());
            map.put("targetDate",ann.getTargetDate());

            LocalDate target = ann.getTargetDate();
            long days;
            String tip;
            if(target.isAfter(today)){
                days = ChronoUnit.DAYS.between(today, target);
                tip = "距离这天还有 " + days + " 天";
            }else if(target.isEqual(today)){
                tip = "✨今天就是纪念日！✨";
            }else{
                days = ChronoUnit.DAYS.between(target, today);
                tip = "已经过去 " + days + " 天啦";
            }
            map.put("tip",tip);
            annVoList.add(map);
        }
        model.addAttribute("annVoList", annVoList);
        return "anniversary/list";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name,
                      @RequestParam String targetDate){
        Anniversary ann = new Anniversary();
        ann.setName(name);
        ann.setTargetDate(LocalDate.parse(targetDate));
        annRepo.save(ann);
        return "redirect:/anniversary/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id){
        annRepo.deleteById(id);
        return "redirect:/anniversary/list";
    }
}