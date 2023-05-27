package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.ReservePlan;
import com.example.labreservesystem.bean.po.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReservePlanMapper {
    List<Student> getStudentByNum(String stu_num);
    List<ReservePlan> getReservePlan();
}
