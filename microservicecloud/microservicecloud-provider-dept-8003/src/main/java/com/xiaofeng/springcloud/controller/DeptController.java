package com.xiaofeng.springcloud.controller;

import com.xiaofeng.springcloud.entity.Dept;
import com.xiaofeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/delete/{deptId}" , method = RequestMethod.GET)
    public Boolean delete(@PathVariable("deptId") Long deptId){
        return deptService.delDept(deptId);
    }

    @RequestMapping(value = "/dept/get/{deptId}", method = RequestMethod.GET)
    public Dept list(@PathVariable("deptId") Long deptId){
        return deptService.get(deptId);
    }

    @RequestMapping("/dept/list")
    public List<Dept> list(){
        return deptService.query();
    }

    @RequestMapping("/dept/discovery")
    public DiscoveryClient discovery(){
        List<String> services = client.getServices();//获取所有的服务
        List<ServiceInstance> instances = client.getInstances("microservicecloud-dept");//根据名称获取对应的服务
        System.out.println(services);
        System.out.println("当前服务的地址:" + instances.get(0).getHost());
        System.out.println("当前服务的端口:" + instances.get(0).getPort());
        System.out.println("当前服务的id:" + instances.get(0).getServiceId());
        return client;
    }
}
