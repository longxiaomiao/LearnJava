package com.sea.thymeleaf.web;

import com.sea.thymeleaf.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model) {
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct = new Product(5, "product e", 200);
        boolean isShow = false;

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "A", 10));
        products.add(new Product(2, "B", 20));
        products.add(new Product(3, "C", 35));
        products.add(new Product(4, "D", 44));
        products.add(new Product(5, "E", 700));
        products.add(new Product(6, "F", 789));
        products.add(new Product(7, "G", 555));

        model.addAttribute("htmlContent", htmlContent);
        model.addAttribute("currentProduct", currentProduct);
        model.addAttribute("isShow", isShow);
        model.addAttribute("products", products);
        return "test";
    }
}
