package com.sea.blog.controllers;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.BlogMapper;
import com.sea.blog.model.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "categoryId", defaultValue = "") String categoryId) {
        PageHelper.startPage(start, size, "CreationTime desc");
        List<Blog> list = blogMapper.findAll(keyword, categoryId);
        PageInfo<Blog> page = new PageInfo<>(list);
        return page;
    }

    @GetMapping("/GetById")
    @ApiOperation(value = "获取单个博客详情", notes = "根据ID获取单个博客详细")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "博客id") })
    public Blog GetBlog(String id) throws Exception {
        return blogMapper.getById(id);
    }

    @PostMapping()
    @ApiOperation(value = "新增博客", notes = "新增博客")
    @ApiImplicitParams({ @ApiImplicitParam(name = "blog", value = "博客") })
    public void Add(Blog blog) throws Exception {
        blogMapper.save(blog);
    }

    @PutMapping()
    @ApiOperation(value = "更新博客", notes = "更新博客")
    @ApiImplicitParams({ @ApiImplicitParam(name = "blog", value = "博客") })
    public void Update(Blog blog) throws Exception {
        blogMapper.update(blog);
    }

    @DeleteMapping()
    @ApiOperation(value = "删除博客", notes = "删除博客")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "博客id") })
    public void Delete(String id) throws Exception {
        blogMapper.delete(id);
    }
}