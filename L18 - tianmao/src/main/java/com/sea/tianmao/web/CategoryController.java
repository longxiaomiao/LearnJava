package com.sea.tianmao.web;

import com.sea.tianmao.pojo.Category;
import com.sea.tianmao.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }
}
