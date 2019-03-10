package com.rookie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rookie.mapper")
public class ShiroExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroExampleApplication.class, args);
    }

}
