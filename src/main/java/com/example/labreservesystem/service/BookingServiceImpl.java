package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.bean.vo.TeaAndReserve;
import com.example.labreservesystem.bean.vo.WeekDayCourse;
import com.example.labreservesystem.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingMapper bookingMapper;
    @Autowired
    TeacherService teacherService;
    @Override
    public Boolean addReserveByTea(ReserveByTea reserveByTea) {
        return bookingMapper.addReserveByTea(reserveByTea);
    }

    @Override
    public ReserveByTea getReserveByTea(String tea_id) {
        return bookingMapper.getReserveByTea(tea_id);
    }

    @Override
    public Semester getSemester(String semester_id) {
        return bookingMapper.getSemester(semester_id);
    }
    //删除暂存预约数据
    @Override
    public Boolean deleteReserveTemporary(String tea_id) {
        return bookingMapper.deleteReserveTemporary(tea_id);
    }

    @Override
    public Boolean addReserveByStu(ReserveByStu reserveByStu) {
        return bookingMapper.addReserveByStu(reserveByStu);
    }

    @Override
    public List<TeaAndReserve> getTeaAndReserve(StuAndTea stuAndTea) {
        return bookingMapper.getTeaAndReserve(stuAndTea);
    }

    @Override
    public List<WeekDayCourse> getMostChoose(StuTeaCourse stuTeaCourse) {
        return bookingMapper.getMostChoose(stuTeaCourse);
    }

    @Override
    //求取教师和学生预约的交集
    public List<ReservePlan> getCrossBetweenStuAndTea(ReserveByTea reserveByTea){
        String tea_id = reserveByTea.getTea_id();
        String trial_name = reserveByTea.getTrial_name();
        List<ReservePlan> res = new ArrayList<>();
        StuTeaCourse stuTeaCourse = new StuTeaCourse(null,tea_id,trial_name);
        StuAndTea stuAndTea = new StuAndTea(null,null,tea_id,null,trial_name);
        List<WeekDayCourse> weekDayCourseList = bookingMapper.getMostChoose(stuTeaCourse);

        List<ReserveByTea> reserveByTeaList = teacherService.getReserveByTea(stuAndTea);

        for(WeekDayCourse weekDayCourse:weekDayCourseList){
            System.out.println(weekDayCourse);
            String week = weekDayCourse.getWeek();
            String day = weekDayCourse.getDay();
            String course = weekDayCourse.getCourse();
            for(ReserveByTea reserveByTea1:reserveByTeaList){
                //星期、日、课程取到相同
                System.out.println(reserveByTea1);
                if(week.equals(reserveByTea1.getWeek()) && day.equals(reserveByTea1.getDay())
                && course.equals(reserveByTea1.getCourse())){
                    ReservePlan reservePlan = new ReservePlan(null,day,week,course,reserveByTea1.getTrial_num(),trial_name,
                            null,false,reserveByTea1.getClass_time(),tea_id,reserveByTea1.getLaboratory(),reserveByTea1.getDepartment());
                    System.out.println(reservePlan);
                    res.add(reservePlan);
                }
            }
        }
        return res;
    }

    @Override
    public List<ReserveByTea> getReserveByTeaList(ReserveByTea reserveByTea) {
        return bookingMapper.getReserveByTeaList(reserveByTea);
    }

    @Override
    public List<ReserveByStu> getReserveByStuSame(ReserveByStu reserveByStu) {
        return bookingMapper.getReserveByStuSame(reserveByStu);
    }
}
