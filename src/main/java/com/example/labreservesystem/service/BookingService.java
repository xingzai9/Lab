package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.bean.vo.TeaAndReserve;
import com.example.labreservesystem.bean.vo.WeekDayCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookingService {
    Boolean addReserveByTea(ReserveByTea reserveByTea);
    ReserveByTea getReserveByTea(String tea_id);
    Semester getSemester(String semester_id);
    Boolean deleteReserveTemporary(String tea_id);

//    加入学生预约详情
    Boolean addReserveByStu(ReserveByStu reserveByStu);

    //学生获取教师开放实验详情
    List<TeaAndReserve> getTeaAndReserve(StuAndTea stuAndTea);

    //获取学生的较多选择
    List<WeekDayCourse> getMostChoose(StuTeaCourse stuTeaCourse);

    List<ReservePlan> getCrossBetweenStuAndTea(ReserveByTea reserveByTea);

    //获取教师预约信息
    List<ReserveByTea> getReserveByTeaList(@Param("reserveByTea") ReserveByTea reserveByTea);
    //获取同一个老师同一门课周日课
    List<ReserveByStu> getReserveByStuSame(@Param("reserveByStuSame")ReserveByStu reserveByStu);
}
