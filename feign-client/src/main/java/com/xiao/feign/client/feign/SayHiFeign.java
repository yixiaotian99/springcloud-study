package com.xiao.feign.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author sunjinwei
 * @Date 1/17/21 8:42 PM
 * @Description 通过 feign 调用其他服务
 **/
@FeignClient(name = "eureka-client")
public interface SayHiFeign {

    @GetMapping("sayHi")
    String sayHi(@RequestParam("name") String name);
}
