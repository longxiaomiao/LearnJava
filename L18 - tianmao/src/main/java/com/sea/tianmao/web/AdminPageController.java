package com.sea.tianmao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
    @GetMapping("/admin")
    public String admin() {
        return "redirect:admin_category_list";
    }

    @GetMapping("/admin_category_list")
    public String listCategory() {
        return "admin/listCategory";
    }
}
