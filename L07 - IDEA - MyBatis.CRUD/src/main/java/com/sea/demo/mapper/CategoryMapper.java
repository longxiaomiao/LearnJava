package com.sea.demo.mapper;

import com.sea.demo.model.category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<category> findAll();
}
