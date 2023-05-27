package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    List<Department>  getAllDepartment();
}
