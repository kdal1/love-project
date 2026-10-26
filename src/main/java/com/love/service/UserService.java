package com.love.service;

import com.love.entity.LoveMsg;
import com.love.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    public User getMyGirlFriend(){
        User girl = new User();
        girl.setId(1);
        girl.setUsername("宝贝");
        girl.setPassword("永远爱你");
        return girl;
    }

    public LoveMsg getLetter(){
        LoveMsg msg = new LoveMsg();
        msg.setMsgId(999);
        msg.setTitle("给我的宝贝");
        msg.setContent("很高兴遇见你，往后岁岁年年，我都想陪着你。不管开心或者难过，我一直在，我会慢慢爱你，一年又一年。");
        return msg;
    }

    // 恋爱天数
    public long getLoveDays(){
        // 改成你们的纪念日：年,月,日
        LocalDate startDay = LocalDate.of(2025, 6, 30);
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(startDay, today);
    }

    // 随机情话
    public LoveMsg getLoveWord(){
        // 准备多条情话
        List<LoveMsg> list = new ArrayList<>();

        LoveMsg m1 = new LoveMsg();
        m1.setMsgId(1);
        m1.setTitle("给我的宝贝");
        m1.setContent("世界一般，但你超值，我永远偏向你。");
        list.add(m1);

        LoveMsg m2 = new LoveMsg();
        m2.setMsgId(2);
        m2.setTitle("给我的宝贝");
        m2.setContent("慢慢相处，慢慢相爱，我们来日方长。");
        list.add(m2);

        LoveMsg m3 = new LoveMsg();
        m3.setMsgId(3);
        m3.setTitle("给我的宝贝");
        m3.setContent("不用奔赴大海，也能春暖花开，有你就足够。");
        list.add(m3);

        LoveMsg m4 = new LoveMsg();
        m4 = new LoveMsg();
        m4.setMsgId(4);
        m4.setTitle("给我的宝贝");
        m4.setContent("我想和你，今年，明年，年年。");
        list.add(m4);

        // 随机挑选一条返回
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
