package com.sea.blog.controllers;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.RoleMapper;
import com.sea.blog.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Role")
@Api(description = "角色接口")
public class RoleController {
    @Autowired
    RoleMapper roleMapper;

    @GetMapping()
    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    public PageInfo<Role> GetList(@RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception {
        PageHelper.startPage(start, size, "ID desc");
        List<Role> list = roleMapper.findAll(keyword);
        PageInfo<Role> page = new PageInfo<>(list);
        return page;
    }
}