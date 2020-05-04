package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocalResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

   // @Override
  /*  public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }*/

  /*  //注册拦截器
 @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**","/templates/**")
                .excludePathPatterns("/emps")
                .excludePathPatterns("emps/list");
    }*/


   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }*/

   /*//配置静态文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
  }*/

  @Bean
   public WebMvcConfigurer webMvcConfigurer(){
       WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/index.html").setViewName("login");
               registry.addViewController("/main.html").setViewName("dashboard");
           }

           //注册拦截器
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
               .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/css/**","/static/**","/js/**","/img/**");
           }
       };
        return webMvcConfigurer;
   }

   @Bean
   public LocaleResolver localeResolver(){
        return new MyLocalResolver();
   }
}
