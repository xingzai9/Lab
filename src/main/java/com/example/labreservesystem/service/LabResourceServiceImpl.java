package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.LabResource;
import com.example.labreservesystem.mapper.LabResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabResourceServiceImpl implements LabResourceService {
    @Autowired
    LabResourceMapper labResourceMapper;

    @Override
    public List<LabResource> getAllLaboratorys() {
        return labResourceMapper.getAllLaboratorys();
    }

    @Override
    public List<String> getLaboratoryByDepartment(String Department) {
        return labResourceMapper.getLaboratoryByDepartment(Department);
    }
}
