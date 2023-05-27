package com.example.labreservesystem.service;

import com.example.labreservesystem.LabReserveSystemApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LabReserveSystemApplication.class)
class LabResourceServiceImplTest {
    @Autowired
    LabResourceService labResourceService;
    @Test
    void getAllLaboratorys() {
        System.out.println(labResourceService.getAllLaboratorys());
    }

    @Test
    void getLaboratoryByDepartment() {
        System.out.println(labResourceService.getLaboratoryByDepartment("计算机"));
    }
}