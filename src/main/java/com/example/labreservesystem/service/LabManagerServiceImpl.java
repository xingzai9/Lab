package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.mapper.LabManagerMapper;
import com.example.labreservesystem.mapper.LabResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class LabManagerServiceImpl implements LabManagerService{
    @Autowired
    LabManagerMapper labManagerMapper;

    @Override
    public LabManager getManagerByNum(String manager_num) {
        return labManagerMapper.getManagerByNum(manager_num);
    }

    @Override
    public List<ReservePlan> getReservePlan(Map<String,Integer> map) {
        return labManagerMapper.getReservePlan(map);
    }

    @Override
    public int getReservePlanCount() {
        return labManagerMapper.getReservePlanCount();
    }

    @Override
    public Boolean deleteById(Integer plan_id) {
        return labManagerMapper.deleteById(plan_id);
    }

    @Override
    public ReservePlan getPlanById(Integer plan_id) {
        return labManagerMapper.getPlanById(plan_id);
    }

    @Override
    public Boolean addReserveEnsure(ReserveEnsure reserveEnsure) {
        return labManagerMapper.addEnsureReserve(reserveEnsure);
    }

    @Override
    public Boolean setIsRefused(Integer plan_id) {
        return labManagerMapper.setIsRefused(plan_id);
    }

    @Override
    public Boolean addRefuse(Message message) {
        return labManagerMapper.addRefuse(message);
    }

    @Override
    public List<ReserveEnsure> getReserveByDepartment(PageUtils<String> pageUtils) {
        return labManagerMapper.getReserveByDepartment(pageUtils);
    }

    @Override
    public Integer getReserveEnsureCount() {
        return labManagerMapper.getReserveEnsureCount();
    }

    @Override
    public List<ReserveEnsure> getReserveEnsure(PageUtils pageUtils) {
        return labManagerMapper.getReserveEnsure(pageUtils);
    }

    @Override
    public Boolean deleteReserveById(String ensure_id) {
        return labManagerMapper.deleteEnsureById(ensure_id);
    }

    @Override
    public List<LabResource> getLabInfo(PageUtils<String> pageUtils) {
        return labManagerMapper.getLabInfo(pageUtils);
    }

    @Override
    public Integer getLabInfoCount() {
        return labManagerMapper.getLabInfoCount();
    }

    @Override
    public Boolean changeState(LabResource labResource) {
        return labManagerMapper.changeState(labResource);
    }

    @Override
    public Boolean updateLab(LabResource labResource) {
        return labManagerMapper.updateLab(labResource);
    }

    @Override
    public Boolean addLab(LabResource labResource) {
        return labManagerMapper.addLab(labResource);
    }

    @Override
    public List<LabManager> getLabManagerList() {
        return labManagerMapper.getLabManagerList();
    }

    @Override
    public List<ReserveEnsure> getReserveEnsureSame(ReserveEnsure reserveEnsure) {
        return labManagerMapper.getReserveEnsureSame(reserveEnsure);
    }

}
