package com.sea.blog.model;

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
    private String Name;

}