package com.xiaofeng.springcloud.controller;

import com.xiaofeng.springcloud.entity.Dept;
import com.xiaofeng.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept){
        System.out.println("---"+dept);
        return deptClientService.addDept(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{deptId}")
    public Dept get(@PathVariable("deptId") Long deptId){
        return deptClientService.get(deptId);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
    }
}
