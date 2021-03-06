package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.Category;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    List<Category> findAll(String keyword);

    void save(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}