package com.kimenyu.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kimenyu.myblog.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
