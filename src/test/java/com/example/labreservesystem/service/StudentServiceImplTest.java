package com.example.labreservesystem.service;

import com.example.labreservesystem.LabReserveSystemApplication;
import com.example.labreservesystem.bean.po.StuAndTea;
import com.example.labreservesystem.bean.po.Student;
import com.example.labreservesystem.bean.po.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LabReserveSystemApplication.class)
class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Test
    void getStudentByNum() {
        Student student = studentService.getStudentByNum("919106840624");
        System.out.println(student);
    }

    @Test
    void addStudent() {
        Student student = new Student(null,"102","123",true,"海鑫","32班","机械院","123@qq");
        boolean res = studentService.addStudent(student);
        System.out.println(res);
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void deleteStudentByNum() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void testGetStudentByNum() {
    }

    @Test
    void testAddStudent() {
    }

    @Test
    void testDeleteStudent() {
    }

    @Test
    void testDeleteStudentByNum() {
    }

    @Test
    void testUpdateStudent() {
    }

    @Test
    void getStudentCount() {
    }

    @Test
    void getMyTeacher() {
////        List<Teacher> teacherList = studentService.getMyTeacher();
//        for(Teacher teacher:teacherList){
//            System.out.println(teacher);
//        }
    }

    @Test
    void testGetStudentByNum1() {
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void getStuAndTea() {
        List<StuAndTea> stuAndTeaList = studentService.getStuAndTea("101");
        for(StuAndTea stuAndTea:stuAndTeaList){
            System.out.println(stuAndTea);
        }
    }
}