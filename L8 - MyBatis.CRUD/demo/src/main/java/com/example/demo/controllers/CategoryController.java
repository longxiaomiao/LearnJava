package com.example.demo.controllers;

import java.util.List;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/ListCategory")
    public String ListCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<Category> result = categoryMapper.findAll(keyword);
        PageInfo<Category> page = new PageInfo<>(result);
        model.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping("/AddCategory")
    public String ListCategory(Category category) throws Exception {
        categoryMapper.save(category);
        return "redirect:ListCategory";
    }

    @RequestMapping("/EditCategory")
    public String ListCategory(int id, Model m) throws Exception {
        Category category = categoryMapper.get(id);
        m.addAttribute("categoryInfo", category);
        return "editCategory";
    }

    @RequestMapping("/UpdateCategory")
    public String UpdateCategory(Category category) throws Exception {
        categoryMapper.update(category);
        return "redirect:ListCategory";
    }

    @RequestMapping("/DeleteCategory")
    public String DeleteCategory(Category category) throws Exception {
        categoryMapper.delete(category.getId());
        return "redirect:ListCategory";
    }
}