package com.xiao.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author sunjinwei
 * @Date 1/17/21 5:23 PM
 * @Description 注册成为 Eureke 客户端服务
 * @see https://blog.csdn.net/forezp/article/details/81040925
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class MyClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyClientApplication.class, args);
    }
}
