package com.xiao.feign.client.hystrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author sunjinwei
 * @Date 1/17/21 8:42 PM
 * @Description 通过 feign 调用其他服务
 * 定义一个 feign 的接口，使用注解 FeignClient 指定调用哪个服务, 使用 fallback 指定回滚的类
 **/
@FeignClient(name = "eureka-client", fallback = SayHiFeignHystrix.class)
public interface SayHiFeign {

    @GetMapping("sayHi")
    String sayHi(@RequestParam("name") String name);
}
