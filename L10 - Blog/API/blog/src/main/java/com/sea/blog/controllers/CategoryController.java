package com.sea.blog.controllers;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.CategoryMapper;
import com.sea.blog.model.Category;

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

    @GetMapping("/findWithBlogs/{id}")
    @ApiOperation(value = "获取分类列表(包含博客信息)", notes = "获取分类列表(包含博客信息)")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "分类id", required = false) })
    public List<Category> GetWithBlogs(String id) throws Exception {
        List<Category> list = categoryMapper.findWithBlogs(id);
        return list;
    }

    @PostMapping()
    @ApiOperation(value = "新增分类", notes = "新增分类")
    @ApiImplicitParams({ @ApiImplicitParam(name = "category", value = "分类") })
    public void Add(Category category) throws Exception {
        categoryMapper.save(category);
    }

    @PutMapping()
    @ApiOperation(value = "更新分类", notes = "更新分类")
    @ApiImplicitParams({ @ApiImplicitParam(name = "category", value = "分类") })
    public void Update(Category category) throws Exception {
        categoryMapper.update(category);
    }

    @DeleteMapping()
    @ApiOperation(value = "删除分类", notes = "删除分类")
    @ApiImplicitParams({ @ApiImplicitParam(name = "category", value = "分类") })
    public void Delete(Category category) throws Exception {
        categoryMapper.delete(category.getId());
    }
}