package com.xiao.zuul.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunjinwei
 * @Date 1/17/21 9:27 PM
 * @Description 开启 zuul 网关功能
 * @see https://blog.csdn.net/forezp/article/details/81041012
 * <p>
 * 使用路由网关 zuul
 * 访问 http://localhost:8766/api-client1/sayHi?name=lisi&token=1 跳转到 eureka-client 上， 并
 * 访问 http://localhost:8766/api-client2/sayHi?name=lisi&token=2 跳转到 feign-client 上
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
@RequestMapping
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyZuulServerApplication.class, args);
    }


}
