package com.netease.nos.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(scanBasePackages = "com.netease.nos")
@ImportResource("classpath:/config/spring-mybatis.xml")
public class Application extends SpringBootServletInitializer{
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
