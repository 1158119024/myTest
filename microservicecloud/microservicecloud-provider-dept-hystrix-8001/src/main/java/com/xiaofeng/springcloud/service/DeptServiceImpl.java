package com.xiaofeng.springcloud.service;

import com.xiaofeng.springcloud.dao.DeptDao;
import com.xiaofeng.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public boolean delDept(Long deptId) {
        return deptDao.delDept(deptId);
    }

    @Override
    public List<Dept> query() {
        return deptDao.query();
    }

    @Override
    public Dept get(Long deptId) {
        return deptDao.get(deptId);
    }
}
