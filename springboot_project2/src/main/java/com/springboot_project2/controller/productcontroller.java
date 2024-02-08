package com.springboot_project2.controller;

import com.springboot_project2.entity.Product;
import com.springboot_project2.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productcontroller {
    @Autowired
    private Productservice service;
    @PostMapping ("/addproduct")
    public Product addproduct(@RequestBody Product product){
        return service.saveproduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addproducts(@RequestBody List<Product> products){
        return service.saveproducts(products);
    }
    @GetMapping("/products")
    public List<Product> findallproduct()
    {
        return service.getproduct();
    }
    @GetMapping("/product/{id}")
    public Product findbyproductid(@PathVariable int id) {
        return service.getproductbyid(id);
    }
    @PutMapping ("update")
    public Product uodateproduct(@RequestBody Product product){
        return service.updateproduct(product);
    }
    @DeleteMapping("/delet/{id}")
    public String deleteproduct(@PathVariable int id){
        return service.deletebyid(id);
    }
}
