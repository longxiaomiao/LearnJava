package com.sea.blog.controllers;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.BlogMapper;
import com.sea.blog.model.Blog;

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
@RequestMapping("/Blog")
@Api(description = "博客接口")
public class BlogController {
    @Autowired
    BlogMapper blogMapper;

    @GetMapping()
    @ApiOperation(value = "获取博客列表", notes = "获取博客列表")
    @ApiImplicitParams({ @ApiImplicitParam(name = "start", value = "页码", required = false),
            @ApiImplicitParam(name = "size", value = "每页行数", required = false),
            @ApiImplicitParam(name = "keyword", value = "搜索关键字", required = false) })
    public PageInfo<Blog> GetList(@RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        PageHelper.startPage(start, size, "CreationTime desc");
        List<Blog> list = blogMapper.findAll(keyword);
        PageInfo<Blog> page = new PageInfo<>(list);
        return page;
    }
}