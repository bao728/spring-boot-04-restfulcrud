package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBoot04RestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04RestfulcrudApplication.class, args);
    }

    public ViewResolver myViewResoler(){
        return new myViewResoler();
    }

    public static class myViewResoler implements  ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
