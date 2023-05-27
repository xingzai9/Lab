package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LabManagerService {
    //根据用户名和密码判断管理员身份
    LabManager getManagerByNum(String manager_num);

    List<ReservePlan> getReservePlan(Map<String,Integer> map);
    int getReservePlanCount();
    Boolean deleteById(Integer plan_id);
    ReservePlan getPlanById(Integer plan_id);
    Boolean addReserveEnsure(ReserveEnsure reserveEnsure);
    Boolean setIsRefused(Integer plan_id);
    Boolean addRefuse(Message message);

    //通过学院获取预约信息
    List<ReserveEnsure> getReserveByDepartment(PageUtils<String> pageUtils);

    //获取确定的预约数量
    Integer getReserveEnsureCount();

    //获取全部预约信息
    List<ReserveEnsure> getReserveEnsure(@Param("pageUtils") PageUtils pageUtils);

    //删除预约信息by-id
    Boolean deleteReserveById(String ensure_id);
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
