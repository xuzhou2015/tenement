package com.tenement.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * @author ：徐周
 * @date ：Created in 2019/12/20 11:14
 * @description：cc
 */
//@EnableCaching
@SpringBootApplication(scanBasePackages = "com.tenement")
@MapperScan("com.tenement.dao")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
