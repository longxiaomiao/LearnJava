package com.sea.blog.mapper;

import com.sea.blog.model.SiteConfig;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SiteConfigMapper {
    SiteConfig get();
}