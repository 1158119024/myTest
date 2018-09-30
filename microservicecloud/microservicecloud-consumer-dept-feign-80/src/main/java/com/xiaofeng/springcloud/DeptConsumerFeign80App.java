package com.xiaofeng.springcloud;

import com.xiaofeng.loadbalancer.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套   客户端负载均衡   的工具。
@RibbonClient(name = "microservicecloud-dept", configuration = MyRule.class)
@EnableFeignClients
public class DeptConsumerFeign80App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign80App.class, args);
    }
}
