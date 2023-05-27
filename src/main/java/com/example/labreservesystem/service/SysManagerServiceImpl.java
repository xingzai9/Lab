package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.Department;
import com.example.labreservesystem.bean.po.LabManager;
import com.example.labreservesystem.bean.po.Semester;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.mapper.SysManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysManagerServiceImpl implements SysManagerService {
    @Autowired
    SysManagerMapper sysManagerMapper;
    @Override
    public List<LabManager> getLabManagerList(PageUtils pageUtils) {
        return sysManagerMapper.getLabManagerList(pageUtils);
    }

    @Override
    public Integer getLabManagerListCount() {
        return sysManagerMapper.getLabManagerListCount();
    }

    @Override
    public Boolean deleteLabManagerById(String manager_id) {
        return sysManagerMapper.deleteLabManagerById(manager_id);
    }

    @Override
    public List<Department> getDepartmentList(PageUtils pageUtils) {
        return sysManagerMapper.getDepartmentList(pageUtils);
    }

    @Override
    public Integer getDepartmentListCount() {
        return sysManagerMapper.getDepartmentListCount();
    }

    @Override
    public Boolean updateDepartment(Department department) {
        return sysManagerMapper.updateDepartment(department);
    }

    @Override
    public Boolean deleteDepartmentById(String dept_id) {
        return sysManagerMapper.deleteDepartmentById(dept_id);
    }

    @Override
    public Boolean addDepartment(Department department) {
        return sysManagerMapper.addDepartment(department);
    }

    @Override
    public Semester getSemester() {
        return sysManagerMapper.getSemester();
    }

    @Override
    public Boolean updateSemester(Semester semester) {
        return sysManagerMapper.updateSemester(semester);
    }

    @Override
    public Boolean deleteSemesterById(String semester_id) {
        return sysManagerMapper.deleteSemesterById(semester_id);
    }
}
