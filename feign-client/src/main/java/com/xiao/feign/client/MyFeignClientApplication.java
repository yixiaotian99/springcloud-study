package com.xiao.feign.client;

import com.xiao.feign.client.feign.SayHiFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunjinwei
 * @Date 1/17/21 8:41 PM
 * @Description 使用 feign 进行远程调用
 *
 * @see https://blog.csdn.net/forezp/article/details/81040965
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@RequestMapping
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFeignClientApplication.class, args);
    }

    private final SayHiFeign sayHiFeign;

    /**
     * 通过 feign调用远端服务
     *
     * @param name
     * @return
     */
    @GetMapping("rpcSayHi")
    public String rpcSayHi(@RequestParam String name) {
        log.info("feign-client call, name={}", name);
        return sayHiFeign.sayHi(name);
    }



    @GetMapping("sayHi")
    public String sayHi(@RequestParam String name) {
        log.info("feign-client call, name={}", name);
        return "feign client name:" + name;
    }
}
