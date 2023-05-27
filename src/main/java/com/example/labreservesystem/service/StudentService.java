package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Student getStudentByNum(String stu_num);
    List<Student> getAllStudents(Map<String,Integer> map);
    boolean addStudent(Student student);
    boolean deleteStudent(Student student);
    boolean deleteStudentByNum(String stu_num);
    boolean updateStudent(Student student);
    int getStudentCount();
    //获取我的教师
    List<Teacher> getMyTeacher(PageUtils pageUtils);
    //获取学生对应的教师数量
    Integer getMyTeacherCount(@Param("pageUtils") PageUtils pageUtils);
    //获取我与老师的对应关系
    List<StuAndTea> getStuAndTea(String stu_num);

    //    获取预约记录
    List<ReserveByStu> getReserveRecord(PageUtils pageUtils);

    Boolean deleteReserveById(String id);
    //更改密码
    Boolean changePassword(@Param("student") Student student);
    //    删除学生预约暂存
    Boolean deleteReserveByStu(@Param("reserveByTea") ReserveByTea reserveByTea);
    //    获取预约记录数量
    Integer getReserveRecordCount(String stu_num);
}
