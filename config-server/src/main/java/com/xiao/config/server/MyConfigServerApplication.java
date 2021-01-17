package com.xiao.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author sunjinwei
 * @Date 1/17/21 5:36 PM
 * @Description 配置中心
 * <p>
 * curl 127.0.0.1:8888/abc/dev3
 * 随便后面写上 abc/dev3 读取正确会返回如下
 * {"name":"abc","profiles":["dev3"],"label":null,"version":"c725ee131807ceeb152ce9d5fd807f09ff0177b2","state":null,"propertySources":[]}
 **/
@SpringBootApplication
@EnableConfigServer
public class MyConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyConfigServerApplication.class, args);
    }
}
