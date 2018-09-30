package com.xiaofeng.springcloud.dao;

import com.xiaofeng.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptDao {

    @Insert("INSERT INTO dept(NAME,dbSource) VALUE(#{name}, DATABASE())")
    public boolean addDept(Dept dept);

    @Delete("DELETE FROM dept WHERE deptId = #{deptId}")
    public boolean delDept(Long deptId);

    @Select("select * from dept")
    public List<Dept> query();

    @Select("select * from dept where deptId = #{deptId}")
    public Dept get(Long deptId);

}
