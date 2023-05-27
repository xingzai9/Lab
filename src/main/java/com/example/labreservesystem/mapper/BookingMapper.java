package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.bean.vo.TeaAndReserve;
import com.example.labreservesystem.bean.vo.WeekDayCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookingMapper {
    Boolean addReserveByTea(@Param("reserveByTea") ReserveByTea reserveByTea);
    ReserveByTea getReserveByTea(String tea_id);
    Semester getSemester(String semester_id);
    Boolean deleteReserveTemporary(String tea_id);

    //学生预约详情加入
    Boolean addReserveByStu(@Param("reserveByStu") ReserveByStu reserveByStu);

    //学生获取老师开放的实验
    List<TeaAndReserve> getTeaAndReserve(@Param("stuAndTea")StuAndTea stuAndTea);

    //获取学生的交集
    List<WeekDayCourse> getMostChoose(@Param("stuTeaCourse")StuTeaCourse stuTeaCourse);
//获取教师预约信息
    List<ReserveByTea> getReserveByTeaList(@Param("reserveByTea") ReserveByTea reserveByTea);
//获取同一个老师同一门课周日课
    List<ReserveByStu> getReserveByStuSame(@Param("reserveByStu")ReserveByStu reserveByStu);
}
