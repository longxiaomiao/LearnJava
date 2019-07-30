package com.example.demo.popj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("p")
public class Product {
    private String Name = "产品";

    @Autowired
    private Category category;
}