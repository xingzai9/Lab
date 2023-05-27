package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface LabManagerMapper {
    //根据用户名和密码判断管理员身份
    LabManager getManagerByNum(String manager_num);

    List<Student> getStudentByNum(String stu_num);
    List<ReservePlan> getReservePlan(Map<String,Integer> map);
    List<ReserveEnsure> getReserveByDepartment(@Param("pageUtils") PageUtils<String> pageUtils);
    List<ReserveEnsure> getReserveEnsure(@Param("pageUtils") PageUtils pageUtils);
    Integer getReserveEnsureCount();
    int getReservePlanCount();
    Boolean deleteById(Integer plan_id);
    ReservePlan getPlanById(Integer plan_id);
    Boolean addEnsureReserve(@Param("reserveEnsure")ReserveEnsure reserveEnsure);
    Boolean setIsRefused(Integer plan_id);
    Boolean addRefuse(@Param("message")Message message);
    Boolean deleteEnsureById(String ensure_id);
//    获取实验室信息
    List<LabResource> getLabInfo(@Param("pageUtils") PageUtils<String> pageUtils);
//    获取实验室信息数量
    Integer getLabInfoCount();

//    更新实验室状态
    Boolean changeState(@Param("labResource")LabResource labResource);
//  更新实验室信息
    Boolean updateLab(@Param("labResource")LabResource labResource);
//  新增实验室
    Boolean addLab(@Param("labResource")LabResource labResource);
//    获取实验室管理员信息
    List<LabManager> getLabManagerList();
//获取确定的相同实验预约
    List<ReserveEnsure> getReserveEnsureSame(@Param("reserveEnsure")ReserveEnsure reserveEnsure);
}
