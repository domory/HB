package com.znzz.equ;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.znzz.equ.mapper")
public class EquApplication {
    public static void main(String[] args) {
        SpringApplication.run(EquApplication.class, args);
    }
}
