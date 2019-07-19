package com.example.demo;

import java.util.List;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CategoryMapper categoryMapper;

	@Test
	public void contextLoads() {
		List<Category> result = categoryMapper.findAll("吴");
		for(Category c : result){
			System.out.println(c.getName());
		}
	}

}
