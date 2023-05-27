package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.Department;
import com.example.labreservesystem.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }
}
