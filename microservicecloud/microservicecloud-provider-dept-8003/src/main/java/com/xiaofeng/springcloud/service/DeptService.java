package com.xiaofeng.springcloud.service;

import com.xiaofeng.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public boolean delDept(Long deptId);

    public List<Dept> query();

    public Dept get(Long deptId);
}
