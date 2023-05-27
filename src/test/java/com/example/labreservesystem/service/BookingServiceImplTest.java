package com.example.labreservesystem.service;

import com.example.labreservesystem.LabReserveSystemApplication;
import com.example.labreservesystem.bean.po.ReserveByStu;
import com.example.labreservesystem.bean.po.ReserveByTea;
import com.example.labreservesystem.bean.po.StuAndTea;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.bean.vo.TeaAndReserve;
import com.example.labreservesystem.bean.vo.WeekDayCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LabReserveSystemApplication.class)
class BookingServiceImplTest {
    @Autowired
    BookingService bookingService;
    @Test
    void addReserveByTea() {
        ReserveByStu reserveByStu = new ReserveByStu(null,"101","1001","第八周","周三","第二大节","材料学院","高分子化合物","二栋301");
        Boolean res = bookingService.addReserveByStu(reserveByStu);
        System.out.println(res);
    }

    @Test
    void getReserveByTea() {
        ReserveByTea reserveByTea = bookingService.getReserveByTea("1001");
        System.out.println(reserveByTea);
    }

    @Test
    void getTeaAndReserve() {
        StuAndTea stuAndTea = new StuAndTea(null,"101","1001","2023春季学期","c++程序设计");
        List<TeaAndReserve> teaAndReserveList = bookingService.getTeaAndReserve(stuAndTea);
        for(TeaAndReserve teaAndReserve:teaAndReserveList){
            System.out.println(teaAndReserve);
        }
    }

    @Test
    void getMostChoose() {
        StuTeaCourse stuTeaCourse = new StuTeaCourse("101","1004","美学设计");
        List<WeekDayCourse> weekDayCourses = bookingService.getMostChoose(stuTeaCourse);
        for(WeekDayCourse weekDayCourse:weekDayCourses){
            System.out.println(weekDayCourse);
        }
    }
}