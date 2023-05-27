package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.LabResource;

import java.util.List;

public interface LabResourceService {
    List<LabResource> getAllLaboratorys();
    List<String> getLaboratoryByDepartment(String Department);
}
