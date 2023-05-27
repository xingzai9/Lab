package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.mapper.TeacherMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
public interface TeacherService {
    Teacher getTeacherById(String tea_id);
    List<Teacher> getAllTeacher(Map map);
    boolean addTeacher(Teacher teacher);
    boolean deleteTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacherById(String tea_id);
    int getTeacherCount();
    List<ReserveByTea> getReserveByTea(StuAndTea stuAndTea);

    List<ReserveByTea> getAllReserveByTea();

    //获取我的预约记录
    List<ReserveEnsure> getReserveRecordById(PageUtils pageUtils);
    //    删除我的预约记录
    Boolean deleteReserveRecordById(String ensure_id);
    //    获取我的学生信息
    List<Student> getMyStudent(PageUtils pageUtils);
    //    删除我的学生
    Boolean deleteMyStudent(StuTeaCourse stuTeaCourse);
    //    获取我的实验
    List<TeaStuSemester> getMyTrial(PageUtils pageUtils);
    //    删除我的实验
    Boolean deleteMyTrial(TeaStuSemester teaStuSemester);
    //删除我的教师预约
    Boolean deleteMyReservePlan(ReserveByTea reserveByTea);
    //增加预约计划
    Boolean addReservePlan(ReservePlan reservePlan);

    //    获取教师预约中信息
    List<ReserveByTea> getReserveByTeaById(PageUtils pageUtils);
    //    根据id删除教师预约信息
    Boolean deleteReserveByTeaById(String reserveByTea_id);
    //    获取教师预约中信息
    Integer getReserveByTeaByIdCount(PageUtils pageUtils);
    //获取我的信息
    List<Message> getMyMessage(@Param("pageUtils")PageUtils pageUtils);
    //    获取我的信息数量
    Integer getMyMessageCount(String tea_id);
    //    更新消息状态
    Boolean changeIsRead(String tea_id);
    //    删除消息
    Boolean deleteMessage(Integer message_id);
    //    获取我的学生数量
    Integer getMyStudentCount(String tea_id);
    //    获取我的试验数量
    Integer getMyTrialCount(String tea_id);
    //    获取教师实验名
    List<String> getTrialNameList(String tea_id);
    //    <!--获取教师预约数量-->
    Integer getReserveRecordByIdCount(String tea_id);
    //    获取推荐实验室
    List<LabResource> getRecommendLaboratory(@Param("reserveEnsure")ReserveEnsure reserveEnsure);
    //   获取教师全部实验
    List<String> getAllTrial(String tea_id);
    //    获取已经被占领的课程
    List<ReserveEnsure> getHoldCourse(@Param("reserveEnsure")ReserveEnsure reserveEnsure);
}
