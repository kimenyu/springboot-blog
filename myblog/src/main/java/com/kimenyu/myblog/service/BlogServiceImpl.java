package com.kimenyu.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimenyu.myblog.entity.Blog;
import com.kimenyu.myblog.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
    
}
