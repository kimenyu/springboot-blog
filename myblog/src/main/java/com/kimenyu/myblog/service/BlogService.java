package com.kimenyu.myblog.service;

import java.util.List;

import com.kimenyu.myblog.entity.Blog;

public interface BlogService {

    public Blog createBlog(Blog blog);

    public List<Blog> getAllBlogs();

}
