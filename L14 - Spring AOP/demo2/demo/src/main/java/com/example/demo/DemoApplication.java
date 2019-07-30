package com.example.demo;

import com.example.demo.services.ProductService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScans({ @ComponentScan("com.example.demo.services"), @ComponentScan("com.example.demo.aspects") })
@EnableAspectJAutoProxy
public class DemoApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println("beanName:" + bean);
		}

		ProductService productService = context.getBean(ProductService.class);
		productService.GetProductList();

		context.close();
	}

}
