package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.Category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper{
    @Select("select * from category ")
    List<Category> findAll();
}