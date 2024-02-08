package com.springboot_project2.service;

import com.springboot_project2.entity.Product;
import com.springboot_project2.repository.product_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productservice {
    @Autowired
    private product_repo reposetory;
    public Product saveproduct(Product product){
        return reposetory.save(product);
    }
    public List<Product>  saveproducts(List<Product> product){
        return reposetory.saveAll(product);
    }
    public List<Product> getproduct()
    {
        return reposetory.findAll();
    }
    public Product getproductbyid(int id)
    {
        return reposetory.findById(id).orElse(null);
    }
    public String deletebyid(int id){
         reposetory.deleteById(id);
         return"product deleted"+id;

    }
    public Product updateproduct (Product product){
        Product exsistingproduct=reposetory.findById(product.getId()).orElse(null);
        exsistingproduct.setName(product.getName());
        exsistingproduct.setPrice(product.getPrice());
        exsistingproduct.setQuantity(product.getQuantity());
        return reposetory.save(exsistingproduct);
    }


}
