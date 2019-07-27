package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Category;

import java.util.List;

import com.example.demo.dao.CategoryDAO;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("/ListCategory")
    public String ListCategory(Model m) throws Exception {
        List<Category> result = categoryDAO.findAll();
        m.addAttribute("CategoryList", result);
        return "ListCategory";
    }
}