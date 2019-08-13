package com.sea.blog.controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sea.blog.mapper.UserMapper;
import com.sea.blog.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/User")
@Api(description = "用户接口")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping()
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    public PageInfo<User> GetList(@RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception {
        PageHelper.startPage(start, size, "ID desc");
        List<User> list = userMapper.findAll(keyword);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @PostMapping()
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public void Add(@Valid User user) throws Exception {
        userMapper.save(user);
    }

    @PutMapping()
    @ApiOperation(value = "编辑用户", notes = "编辑用户")
    public void Update(@Valid User user) throws Exception {
        userMapper.update(user);
    }

    @DeleteMapping()
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public void Delete(String id) throws Exception {
        userMapper.delete(id);
    }
}