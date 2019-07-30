package com.example.demo;

import com.example.demo.popj.Product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.demo.popj")
public class DemoApplication {
	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
		// { "applicationContext.xml" });
		ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println("beanName: " + beanName);
		}

		// Product product = context.getBean(Product.class);
		Product product = (Product) context.getBean("p");
		System.out.println(product.getName());
		System.out.println(product.getCategory().getName());
	}

}
