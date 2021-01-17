package com.xiao.eureka.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunjinwei
 * @Date 1/17/21 5:23 PM
 * @Description 注册成为 Eureke 客户端服务
 * @see https://blog.csdn.net/forezp/article/details/81041028
 * <p>
 * <p>
 * http请求地址和资源文件映射如下:  localhost:8802/eureka-client-pull-config/dev/main
 * <p>
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 **/
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RestController
@RequestMapping("/")
public class MyClientPullConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyClientPullConfigApplication.class, args);
    }


    /**
     * 注册配置中心文件中属性值
     */
    @Value("${test.name}")
    private String name;

    @Value("${test.address}")
    private String address;


    /**
     * 返回配置中心配置值
     * localhost:8802/eureka-client-pull-config/dev/main
     */
    @GetMapping("pull")
    public String pullConfig() {
        log.info("config client pull config, test name:{}, address:{}", name, address);
        return name + "-" + address;
    }
}
