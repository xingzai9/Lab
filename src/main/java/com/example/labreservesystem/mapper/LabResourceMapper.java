package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.LabResource;
import com.example.labreservesystem.bean.po.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LabResourceMapper {
    List<LabResource> getAllLaboratorys();
    List<String> getLaboratoryByDepartment(String Department);
}
