package com.example.demo.config;

// import com.example.demo.aspects.LoggerAspect;
// import com.example.demo.services.ProductService;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScans({ @ComponentScan("com.example.demo.aspects"), @ComponentScan("com.example.demo.services") })
public class ServiceConfig {
    // @Bean
    // public ProductService productService() {
    // return new ProductService();
    // }

    // @Bean
    // public LoggerAspect loggerAspect(){
    // return new LoggerAspect();
    // }
}