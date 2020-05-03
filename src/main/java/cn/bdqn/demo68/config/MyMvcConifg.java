package cn.bdqn.demo68.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @outhor shkstart
 * 浮瑞龙
 */
@Configuration
public class MyMvcConifg implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("HomPage");
        registry.addViewController("/").setViewName("HomPage");
    }
}