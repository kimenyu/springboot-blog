package com.kimenyu.myblog.repository;


import com.kimenyu.myblog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
