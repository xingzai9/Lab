package com.example.labreservesystem.mapper;

import com.example.labreservesystem.LabReserveSystemApplication;
import com.example.labreservesystem.bean.po.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LabReserveSystemApplication.class)
class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudentByNum() {
        Student student = studentMapper.getStudentByNum("1");
        System.out.println(student);
    }
}