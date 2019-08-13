package com.sea.blog.mapper;

import java.util.List;

import com.sea.blog.model.Category;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    List<Category> findAll(String keyword);

    void save(Category category);

    void update(Category category);

    void delete(String id);

    List<Category> findWithBlogs(String id);
}