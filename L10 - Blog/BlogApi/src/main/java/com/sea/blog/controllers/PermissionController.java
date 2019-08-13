package com.sea.blog.controllers;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.PermissionMapper;
import com.sea.blog.model.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "权限接口")
@RequestMapping("/Permission")
public class PermissionController {
    @Autowired
    PermissionMapper permissionMapper;

    @GetMapping()
    @ApiOperation(value = "获取权限列表", notes = "获取权限列表")
    public PageInfo<Permission> GetList(@RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception {
        PageHelper.startPage(start, size, "ID desc");
        List<Permission> list = permissionMapper.findAll(keyword);
        PageInfo<Permission> page = new PageInfo<>(list);
        return page;
    }
}