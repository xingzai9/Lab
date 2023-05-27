package com.example.labreservesystem.service;

import com.example.labreservesystem.LabReserveSystemApplication;
import com.example.labreservesystem.bean.po.ReserveEnsure;
import com.example.labreservesystem.bean.vo.PageUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = LabReserveSystemApplication.class)
class LabManagerServiceImplTest {
    @Autowired
    LabManagerService labManagerService;
    @Test
    void getReservePlan() {
//        System.out.println(labManagerService.getReservePlan(Map<String,Integer> map));
    }

    @Test
    void getReserveEnsure() {
        PageUtils pageUtils = new PageUtils<>(0,3,null);
        List<ReserveEnsure> reserveEnsures = labManagerService.getReserveEnsure(pageUtils);
        for (ReserveEnsure reserveEnsure:reserveEnsures){
            System.out.println(reserveEnsure);
        }
    }
}