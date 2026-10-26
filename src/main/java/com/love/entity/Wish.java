package com.love.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wish")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Boolean finished;

    private LocalDateTime createTime;

    // 无参构造（JPA必须要有）
    public Wish() {
    }

    // 全参构造，按需
    public Wish(Long id, String content, Boolean finished, LocalDateTime createTime) {
        this.id = id;
        this.content = content;
        this.finished = finished;
        this.createTime = createTime;
    }

    // getter、setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}