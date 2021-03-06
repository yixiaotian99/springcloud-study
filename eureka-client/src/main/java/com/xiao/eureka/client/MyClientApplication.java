package com.xiao.eureka.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunjinwei
 * @Date 1/17/21 5:23 PM
 * @Description 注册成为 Eureke 客户端服务
 * @see https://blog.csdn.net/forezp/article/details/81040925
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RequestMapping
@RestController
@Slf4j
public class MyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyClientApplication.class, args);
    }

    @GetMapping("sayHi")
    public String sayHi(@RequestParam String name) {
        log.info("sayHi:{}", name);
        return "sayHi:" + name;
    }
}
