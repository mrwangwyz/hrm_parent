package com.wyz.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.wyz.hrm.mapper")
public class Sysmanage9001Application {
    public static void main(String[] args) {
        SpringApplication.run(Sysmanage9001Application.class,args);
    }
}
