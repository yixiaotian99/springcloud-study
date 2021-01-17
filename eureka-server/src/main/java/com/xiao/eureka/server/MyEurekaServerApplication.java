package com.xiao.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author sunjinwei
 * @Date 1/17/21 5:11 PM
 * @Description 注册中心 服务端
 * @see https://blog.csdn.net/forezp/article/details/81040925
 *
 **/
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyEurekaServerApplication.class, args);
    }
}
