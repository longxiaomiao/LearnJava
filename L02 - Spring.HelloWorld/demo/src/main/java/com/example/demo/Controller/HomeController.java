package com.example.demo.Controller;

import java.util.ArrayList;

import com.example.demo.Models.UserModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{

    @RequestMapping("/test")
    public String Index(){
        return "hello world";
    }

    @RequestMapping("/getUsers")
    public ArrayList<UserModel> UserList(){
        ArrayList<UserModel> users = new ArrayList<UserModel>();
        users.add(new UserModel("sea", "wuhan"));
        users.add(new UserModel("nian", "wuhan"));
        users.add(new UserModel("xiexing", "dongguan"));
        return users;
    }
}