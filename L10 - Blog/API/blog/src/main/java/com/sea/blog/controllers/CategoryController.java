package com.sea.blog.controllers;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.CategoryMapper;
import com.sea.blog.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Category")
@Api(description = "博客分类接口")
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping()
    @ApiOperation(value = "获取分类列表", notes = "获取分类列表")
    @ApiImplicitParams({ @ApiImplicitParam(name = "start", value = "页码", required = false),
            @ApiImplicitParam(name = "size", value = "每页大小", required = false),
            @ApiImplicitParam(name = "keyword", value = "搜索关键字", required = false) })
    public PageInfo<Category> GetList(@RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        PageHelper.startPage(start, size, "CreationTime desc");
        List<Category> list = categoryMapper.findAll(keyword);
        PageInfo<Category> page = new PageInfo<>(list);
        return page;
    }
}