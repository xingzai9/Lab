package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface TeacherMapper {
    Teacher getTeacherById(String tea_id);//id查找
    List<Teacher> getAllTeacher(Map map);
    boolean addTeacher(@Param("teacher")Teacher teacher);//增加老师
    boolean updateTeacher(@Param("teacher") Teacher teacher);//更新教师信息
    boolean deleteTeacher(Teacher teacher);//删除老师信息
    boolean deleteTeacherById(String tea_id);//通过教师编号删除信息
    int getTeacherCount();
    //获取教师临时预约
    List<ReserveByTea> getReserveByTea(@Param("stuAndTea")StuAndTea stuAndTea);
    //获取全部教师拟预约
    List<ReserveByTea> getAllReserveByTea();

    //获取我的预约记录
    List<ReserveEnsure> getReserveRecordById(@Param("pageUtils") PageUtils pageUtils);
    Integer getReserveRecordByIdCount(String tea_id);
    //    删除我的预约记录
    Boolean deleteReserveRecordById(String ensure_id);
    //    获取我的学生信息
    List<Student> getMyStudent(@Param("pageUtils")PageUtils pageUtils);
    //    删除我的学生
    Boolean deleteMyStudent(@Param("stuTeaCourse") StuTeaCourse stuTeaCourse);
    //    获取我的实验
    List<TeaStuSemester> getMyTrial(@Param("pageUtils")PageUtils pageUtils);
    //    删除我的实验
    Boolean deleteMyTrial(@Param("teaStuSemester")TeaStuSemester teaStuSemester);
//    删除我的教师预约

    Boolean deleteMyReservePlan(@Param("reserveByTea") ReserveByTea reserveByTea);

//增加预约计划
    Boolean addReservePlan(@Param("reservePlan")ReservePlan reservePlan);

//    获取教师预约中信息
    List<ReserveByTea> getReserveByTeaById(@Param("pageUtils")PageUtils pageUtils);
//    根据id删除教师预约信息
    Boolean deleteReserveByTeaById(String reserveByTea_id);
    //    获取教师预约中信息
    Integer getReserveByTeaByIdCount(@Param("pageUtils")PageUtils pageUtils);
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
    Integer getReserveRecordById(String tea_id);
//    获取推荐实验室
    List<LabResource> getRecommendLaboratory(@Param("reserveEnsure")ReserveEnsure reserveEnsure);
    //   获取教师全部实验
    List<String> getAllTrial(String tea_id);
//    获取已经被占领的课程
    List<ReserveEnsure> getHoldCourse(@Param("reserveEnsure")ReserveEnsure reserveEnsure);
}
