package com.sea.blog.mapper;

import java.util.List;

import com.sea.blog.model.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<User> findAll(String keyword);

    void save(User user);

    void update(User user);

    void delete(String id);
}