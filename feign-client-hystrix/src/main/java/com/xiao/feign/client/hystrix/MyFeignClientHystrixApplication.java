package com.xiao.feign.client.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiao.feign.client.hystrix.feign.SayHiFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunjinwei
 * @Date 1/17/21 8:57 PM
 * @Description 使用feign带断路器功能
 * @see https://blog.csdn.net/forezp/article/details/81040990
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@RequestMapping
@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyFeignClientHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFeignClientHystrixApplication.class, args);
    }

    private final SayHiFeign sayHiFeign;

    /**
     * 通过 feign调用远端服务
     *
     * @param name
     * @return
     */
    @GetMapping("rpcSayHi")
    public String sayHi(@RequestParam String name) {
        log.info("feign client hystrix sayHi call, name:{}", name);
        return sayHiFeign.sayHi(name);
    }


    /**
     * 测试熔断，当有异常发生时，如 1/0 异常就会导致熔断
     *
     * 访问地址 http://localhost:8765/actuator/hystrix.stream
     * <p>
     * 监控地址：localhost:8765/hystrix
     *
     * @param name
     * @return
     */
    @GetMapping("sayHello")
    @HystrixCommand(fallbackMethod = "sayHelloFallBack")
    public String sayHello(@RequestParam String name) {
        log.info("feign client hystrix sayHello call, name:{}", name);

        //测试熔断
//        int n = 1 / 0;

        return "测试熔断, name=" + name;
    }

    /**
     * 熔断降级方法
     * 必须和原方法有相同的方法签名，原方法有 String name 参数，熔断降级方法也必须有
     *
     * @return
     */
    private String sayHelloFallBack(String name) {
        return "熔断发生，请重新操作";
    }
}

