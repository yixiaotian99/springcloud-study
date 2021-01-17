package com.xiao.bus.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunjinwei
 * @Date 1/17/21 9:54 PM
 * @Description 使用消息总线，实现配置文件修改发出消息通知，使用 rabbitmq 进行消息通知
 * @see https://blog.csdn.net/forezp/article/details/81041062
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RefreshScope
@RestController
@Slf4j
public class MyBusServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBusServerApplication.class, args);
    }


    /**
     * 注册配置中心文件中属性值
     */
    @Value("${test.address}")
    private String address;


    /**
     * 返回配置中心配置值
     * 刷新配置  /actuator/bus-refresh?destination=服务名:**
     * 如 /actuator/bus-refresh?destination=bus-server:**
     * 或 /actuator/bus-refresh
     */
    @GetMapping("pull")
    public String pull() {
        log.info("config client bus pull address:{}", address);
        return address;
    }
}
