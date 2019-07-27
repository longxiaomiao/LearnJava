package com.example.demo.controllers;

import java.util.List;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/ListCategory")
    public String ListCategory(Model model) throws Exception {
        List<Category> result = categoryMapper.findAll();
        model.addAttribute("list", result);
        return "listCategory";
    }
}