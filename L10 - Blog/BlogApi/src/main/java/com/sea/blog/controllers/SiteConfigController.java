package com.sea.blog.controllers;

import com.sea.blog.mapper.SiteConfigMapper;
import com.sea.blog.model.SiteConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/SiteConfig")
@Api(description = "获取网站配置信息")
public class SiteConfigController {
    @Autowired
    SiteConfigMapper siteConfigMapper;

    @GetMapping()
    @ApiOperation(value = "获取网站配置", notes = "获取网站配置")
    public SiteConfig GetSiteConfig() {
        return siteConfigMapper.get();
    }
}