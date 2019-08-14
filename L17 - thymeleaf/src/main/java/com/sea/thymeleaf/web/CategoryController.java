package com.sea.thymeleaf.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.thymeleaf.mapper.CategoryMapper;
import com.sea.thymeleaf.pojo.Category;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<Category> list = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(list);
        model.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(Model model, int id) throws Exception {
        Category category = categoryMapper.get(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
        categoryMapper.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(int id) throws Exception {
        categoryMapper.delete(id);
        return "redirect:listCategory";
    }
}
