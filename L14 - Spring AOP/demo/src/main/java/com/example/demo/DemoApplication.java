package com.example.demo;

import com.example.demo.config.ServiceConfig;
import com.example.demo.services.ProductService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
		String[] beans = context.getBeanDefinitionNames();
		for (String name : beans) {
			System.out.println("beanName:" + name);
		}
		ProductService productService = context.getBean(ProductService.class);
		productService.GetProductList();
		context.close();
	}
}
