package com.sea.blog.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Blog {
    private String Id;
    private String CreatorUserId;
    private Date CreationTime;
    private String LastModifierUserId;
    private Date LastModificationTime;
    private String DeleterUserId;
    private Date DeletionTime;
    private Boolean IsDeleted;
    private String Slug;
    private String Title;
    private String Summary;
    private String Content;
    private Boolean IsShow;
    private List<BlogCategory> blogCategories;
}