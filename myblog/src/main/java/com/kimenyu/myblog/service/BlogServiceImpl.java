package com.kimenyu.myblog.service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Blog fetchById(Long blogId) {
        return blogRepository.findById(blogId).get();
    }

    @Override
    public Blog updateBlog(Long blogId, Blog blog) {
        Blog blogDb = blogRepository.findById(blogId).get();

        if(Objects.nonNull(blog.getTitle()) && !"".equalsIgnoreCase(blog.getTitle())) {
            blogDb.setTitle(blog.getTitle());
        }

        if(Objects.nonNull(blog.getContent()) && !"".equalsIgnoreCase(blog.getContent())) {
            blogDb.setContent(blog.getContent());
        }

        return blogRepository.save(blogDb);
    }
    
    @Override
    public void deleteBlogById(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
