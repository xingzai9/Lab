package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.mapper.StudentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public boolean deleteStudent(Student student) {
        return studentMapper.deleteStudent(student);
    }

    @Override
    public boolean deleteStudentByNum(String stu_num) {
        return studentMapper.deleteStudentByNum(stu_num);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int getStudentCount() {
        return studentMapper.getStudentCount();
    }

    @Override
    public List<Teacher> getMyTeacher(PageUtils pageUtils) {
        return studentMapper.getMyTeacher(pageUtils);
    }

    @Override
    public Integer getMyTeacherCount(PageUtils pageUtils) {
        return studentMapper.getMyTeacherCount(pageUtils);
    }

    @Override
    public List<StuAndTea> getStuAndTea(String stu_num) {
        return studentMapper.getStuAndTea(stu_num);
    }

    @Override
    public List<ReserveByStu> getReserveRecord(PageUtils pageUtils) {
        return studentMapper.getReserveRecord(pageUtils);
    }

    @Override
    public Boolean deleteReserveById(String id) {
        return studentMapper.deleteReserveById(id);
    }

    @Override
    public Boolean changePassword(Student student) {
        return studentMapper.changePassword(student);
    }

    @Override
    public Boolean deleteReserveByStu(ReserveByTea reserveByTea) {
        return studentMapper.deleteReserveByStu(reserveByTea);
    }

    @Override
    public Integer getReserveRecordCount(String stu_num) {
        return studentMapper.getReserveRecordCount(stu_num);
    }

    @Override
    public Student getStudentByNum(String stu_num) {
        return studentMapper.getStudentByNum(stu_num);
    }

    @Override
    public List<Student> getAllStudents(Map<String,Integer> map) {
        return studentMapper.getAllStudents(map);
    }

}
