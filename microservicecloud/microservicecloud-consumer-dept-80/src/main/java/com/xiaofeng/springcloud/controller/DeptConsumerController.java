package com.xiaofeng.springcloud.controller;

import com.xiaofeng.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

//    private static final String REST_URL_PERFIX = "http://localhost:8001";
    /*
        通过服务名称访问对应的服务，无需关心服务的地址与端口
        microservicecloud-dept：这个名称就是在服务端的application.yml文件中
            spring:
               application:
                name: microservicecloud-dept
     */
    private static final String REST_URL_PERFIX = "http://microservicecloud-dept";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept){
        System.out.println("---"+dept);
        return restTemplate.postForObject( REST_URL_PERFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{deptId}")
    public Dept get(@PathVariable("deptId") Long deptId){
        return restTemplate.getForObject(REST_URL_PERFIX+"/dept/get/"+deptId, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PERFIX+"/dept/list", List.class);
    }
}
