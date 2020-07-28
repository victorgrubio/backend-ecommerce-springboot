package com.victorgarciarubio.ecommerce.dao;

import com.victorgarciarubio.ecommerce.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}