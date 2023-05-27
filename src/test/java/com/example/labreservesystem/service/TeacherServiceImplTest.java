package com.example.labreservesystem.service;

import com.example.labreservesystem.LabReserveSystemApplication;
import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LabReserveSystemApplication.class)
class TeacherServiceImplTest {

    @Autowired
    TeacherService teacherService;
    @Test
    void addTeacher() {
        Teacher teacher = new Teacher(0,"111","孙廷凯","123",true,"计算机院","308@qq");
        boolean res = teacherService.addTeacher(teacher);
        System.out.println(res);
    }

    @Test
    void getTeacherById() {
        Teacher teacher = teacherService.getTeacherById("1001");
        System.out.println(teacher);
    }

    @Test
    void deleteTeacher() {
    }

    @Test
    void updateTeacher() {
        Teacher teacher = new Teacher(1,"213","322","222",true,"321","32");
        boolean res = teacherService.updateTeacher(teacher);
        System.out.println(res);
    }

    @Test
    void deleteTeacherById() {
    }

    @Test
    void getReserveByTea() {
        StuAndTea stuAndTea = new StuAndTea(1,"101","1001","2023春季学期","硬件课程设计2");
        List<ReserveByTea> reserveByTeaList = teacherService.getReserveByTea(stuAndTea);
        for(ReserveByTea reserveByTea:reserveByTeaList){
            System.out.println(reserveByTea);
        }
    }

    @Test
    void getAllReserveByTea() {
        List<ReserveByTea> reserveByTeaList = teacherService.getAllReserveByTea();
        for(ReserveByTea reserveByTea:reserveByTeaList){
            System.out.println(reserveByTea);
        }
    }

    @Test
    void deleteMyStudent() {
        StuTeaCourse stuTeaCourse = new StuTeaCourse("101","1001","c++程序设计");
        Boolean res = teacherService.deleteMyStudent(stuTeaCourse);
        System.out.println(res);
    }

    @Test
    void getRecommendLaboratory() {
        ReserveEnsure reserveEnsure = new ReserveEnsure();
        reserveEnsure.setDepartment("计算机科学与工程学院");
        reserveEnsure.setLaboratory("硬件设计实验室");
        reserveEnsure.setTrial_num(35);
        reserveEnsure.setWeek("第1周");
        reserveEnsure.setDay("周一");
        reserveEnsure.setCourse("1");
        List<LabResource> labResourceList = teacherService.getRecommendLaboratory(reserveEnsure);
        for(LabResource labResource:labResourceList){
            System.out.println(labResource);
        }
    }
}