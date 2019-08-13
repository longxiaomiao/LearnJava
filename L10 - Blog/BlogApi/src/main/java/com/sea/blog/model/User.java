package com.sea.blog.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class User {
    private String ID;
    @NotBlank(message = "请输入用户名")
    private String Name;
    @NotBlank(message = "请输入密码")
    private String Password;
}