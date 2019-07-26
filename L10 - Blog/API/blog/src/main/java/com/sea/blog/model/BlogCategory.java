package com.sea.blog.model;

import lombok.Data;

@Data
public class BlogCategory {
    private String BlogID;
    private String CategoryID;
    private Blog blog;
    private Category category;
}