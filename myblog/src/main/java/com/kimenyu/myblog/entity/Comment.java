package com.kimenyu.myblog.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
}

