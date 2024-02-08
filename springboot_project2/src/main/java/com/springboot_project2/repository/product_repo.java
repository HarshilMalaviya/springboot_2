package com.springboot_project2.repository;

import com.springboot_project2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface product_repo extends JpaRepository<Product,Integer>{

}
