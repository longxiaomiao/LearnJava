package com.sea.thymeleaf.mapper;

import com.sea.thymeleaf.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category")
    List<Category> findAll();

    @Select("select * from category where id = #{id}")
    Category get(int id);

    @Update("update category set name=#{name} where id = #{id}")
    int update(Category c);

    @Insert("insert into category(name) values(#{name})")
    int save(Category c);

    @Delete("delete from category where id = #{id}")
    int delete(int id);
}
