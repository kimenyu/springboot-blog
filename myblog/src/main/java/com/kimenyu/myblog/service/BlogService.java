package com.kimenyu.myblog.service;

import java.util.List;

import com.kimenyu.myblog.entity.Blog;

public interface BlogService {

    public Blog createBlog(Blog blog);

    public List<Blog> getAllBlogs();

    public Blog fetchById(Long blogId);

    public Blog updateBlog(Long blogId, Blog blog);

    public void deleteBlogById(Long blogId);
}
