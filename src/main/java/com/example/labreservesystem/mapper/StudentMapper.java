package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface StudentMapper {
    Student getStudentByNum(String stu_num);
    List<Student> getAllStudents(Map<String,Integer> map);
    boolean addStudent(@Param("student") Student student);
    boolean deleteStudent(@Param("student") Student student);
    boolean updateStudent(@Param("student") Student student);
    boolean deleteStudentByNum(String stu_num);
    int getStudentCount();
    //获取学生对应的教师信息
    List<Teacher> getMyTeacher(@Param("pageUtils") PageUtils pageUtils);
    //获取学生对应的教师数量
    Integer getMyTeacherCount(@Param("pageUtils") PageUtils pageUtils);
    //获取我的老师的对应关系
    List<StuAndTea> getStuAndTea(String Stu_num);

//    获取我的预约记录
    List<ReserveByStu> getReserveRecord(@Param("pageUtils") PageUtils pageUtils);

//    删除我的预约记录
    Boolean deleteReserveById(String id);
//更改密码
    Boolean changePassword(@Param("student") Student student);
//    删除学生预约暂存
    Boolean deleteReserveByStu(@Param("reserveByTea")ReserveByTea reserveByTea);
//    获取预约记录数量
    Integer getReserveRecordCount(String stu_num);
}
