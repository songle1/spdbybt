package com.topcheer.spdbybt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.topcheer.spdbybt.mapper")//告诉springboot我们的mapper位置在哪
public class SpdbybtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpdbybtApplication.class, args);
    }

}

