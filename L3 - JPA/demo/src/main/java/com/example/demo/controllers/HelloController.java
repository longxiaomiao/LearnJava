package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.*;
import java.util.Date;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        model.addAttribute("name", "hello spring boot");
        int a = 0;
        int b = 10 / a;
        model.addAttribute("b", b);
        return "hello";
    }
}