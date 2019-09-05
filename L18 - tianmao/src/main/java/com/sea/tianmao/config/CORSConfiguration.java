package com.sea.tianmao.config;

import com.sea.tianmao.interceptor.LoginInterceptor;
import com.sea.tianmao.interceptor.OtherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**");
        registry.addInterceptor(getOtherInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Bean
    public OtherInterceptor getOtherInterceptor() {
        return new OtherInterceptor();
    }
}
