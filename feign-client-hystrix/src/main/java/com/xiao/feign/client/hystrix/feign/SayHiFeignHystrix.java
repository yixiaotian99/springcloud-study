package com.xiao.feign.client.hystrix.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 1/17/21 8:58 PM
 * @Description 将 feign 服务进行熔断
 **/
@Slf4j
@Component
public class SayHiFeignHystrix implements SayHiFeign {


    @Override
    public String sayHi(String name) {

        log.warn("服务降级，熔断处理, name:{}", name);

        return name + ",熔断";
    }
}
