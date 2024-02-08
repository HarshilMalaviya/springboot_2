package com.springboot_project2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="PRODUCT_INF0")

public class Product  {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;
}

