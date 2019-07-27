package com.sea.demo.controllers;

import com.sea.demo.mapper.CategoryMapper;
import com.sea.demo.model.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/ListCategory")
    public String ListCategory(Model model) throws Exception{
        List<category> result = categoryMapper.findAll();
        model.addAttribute("list",result);
        return "listCategory";
    }
}
