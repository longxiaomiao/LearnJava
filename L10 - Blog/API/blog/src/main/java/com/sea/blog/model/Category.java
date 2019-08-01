package com.sea.blog.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Category {
    private String Id;
    private String CreatorUserId;
    private String CreationTime;
    private String LastModifierUserId;
    private String LastModificationTime;
    private String DeleterUserId;
    private String DeletionTime;
    private String IsDeleted;

    @NotBlank(message = "请输入分类名称")
    private String Name;
    private List<Blog> blogs;
}