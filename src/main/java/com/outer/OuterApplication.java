package com.outer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin//允许跨越访问
@SpringBootApplication//springBoot项目入口
@EnableDubboConfiguration
public class OuterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OuterApplication.class, args);
    }
}
