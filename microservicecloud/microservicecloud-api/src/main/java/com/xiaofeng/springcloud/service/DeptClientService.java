package com.xiaofeng.springcloud.service;

import com.xiaofeng.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("microservicecloud-dept")
public interface DeptClientService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean addDept(Dept dept);

//    public boolean delDept(Long deptId);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/get/{deptId}", method = RequestMethod.GET)
    public Dept get(@PathVariable("deptId") Long deptId);
}
