package com.sea.blog.mapper;

import java.util.List;

import com.sea.blog.model.Role;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    List<Role> findAll(String keyword);
}