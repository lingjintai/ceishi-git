package com.atguigu.springboot.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //浏览器发送请求atguigu 也来到成功页面
        registry.addViewController("/atguigu").setViewName("success");
    }


    ///所有的WebMvcConfigurer组件会一起起作用

    @Bean //将组件注册在容器中 不然springboot是不会发现的
    public  WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {

             @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("index.html").setViewName("login");

            }
        };

        return  adapter;
    }

}
