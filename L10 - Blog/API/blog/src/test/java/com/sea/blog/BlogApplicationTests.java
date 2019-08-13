package com.sea.blog;

import java.util.List;

import com.sea.blog.mapper.BlogMapper;
import com.sea.blog.mapper.CategoryMapper;
import com.sea.blog.model.Blog;
import com.sea.blog.model.BlogCategory;
import com.sea.blog.model.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	BlogMapper blogMapper;
	@Autowired
	CategoryMapper categoryMapper;

	@Test
	public void contextLoads() {
		List<Blog> blogs = blogMapper.findAll("","");
		for (Blog blog : blogs) {
			System.out.println(blog.getId() + " - " + blog.getTitle());
			if (blog.getBlogCategories() != null) {
				for (BlogCategory bc : blog.getBlogCategories()) {
					System.out.println("**" + bc.getCategory().getName() + "**");
				}
			} else {
				System.out.println("--没有关系--");
			}
		}
	}

	@Test
	public void findWithBlogsTest() {
		List<Category> categories = categoryMapper.findWithBlogs("8c8d81c2-0ad9-4569-afca-5c53079fbdac");
		for (Category c : categories) {
			System.out.println(c.getName());
			for (Blog b : c.getBlogs()) {
				System.out.println(b.getTitle());
			}
		}
	}

}
