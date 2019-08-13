package com.sea.blog.mapper;

import java.util.List;

import com.sea.blog.model.Permission;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {
    List<Permission> findAll(String keyword);
}