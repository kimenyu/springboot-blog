package com.kimenyu.myblog.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimenyu.myblog.entity.Blog;
import com.kimenyu.myblog.entity.OurUsers;
import com.kimenyu.myblog.repository.OurUserRepo;
import com.kimenyu.myblog.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private OurUserRepo repo;

    
    @PostMapping("/create-blog")
    public Blog createBlog(@RequestBody Blog blog) {
        // Get the currently authenticated user's email
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail = userDetails.getUsername();

        // Find the user by email
        Optional<OurUsers> optionalUser = repo.findByEmail(userEmail);

        if (optionalUser.isPresent()) {
            OurUsers author = optionalUser.get();
            
            // Set the author of the blog post
            blog.setAuthor(author);

            // Save the blog post
            return blogService.createBlog(blog);
        } else {
            // Handle the case when the user is not found (optional)
            throw new RuntimeException("User not found with email: " + userEmail);
        }


    }

    @GetMapping("/list-blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

}
