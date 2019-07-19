package com.example.demo.controllers;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("/listCategory")
    public String ListCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        m.addAttribute("CategoryList", page);
        return "listCategory";
    }

    @RequestMapping("/addCategory")
    public String AddCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String UpdateCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String DeleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(int id, Model m) throws Exception {
        Category c = categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}