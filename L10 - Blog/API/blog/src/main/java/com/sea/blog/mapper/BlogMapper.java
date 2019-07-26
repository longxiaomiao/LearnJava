package com.sea.blog.mapper;

import java.util.List;

import com.sea.blog.model.Blog;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    List<Blog> findAll(String keyword);

    void save(Blog blog);

    void update(Blog blog);

    void delete(String id);
}