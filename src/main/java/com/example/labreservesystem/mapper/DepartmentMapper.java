package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> getAllDepartment();
}
