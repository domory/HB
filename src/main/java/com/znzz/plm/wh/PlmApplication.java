package com.znzz.plm.wh;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.znzz.plm.wh.mapper")
public class PlmApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlmApplication.class, args);
    }
}
