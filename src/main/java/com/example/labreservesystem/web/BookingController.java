package com.example.labreservesystem.web;

import com.alibaba.fastjson.JSONArray;
import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.bean.vo.TeaAndReserve;
import com.example.labreservesystem.bean.vo.WeekDayCourse;
import com.example.labreservesystem.mapper.SysManagerMapper;
import com.example.labreservesystem.service.*;
import com.example.labreservesystem.bean.vo.ServerResponse;
import com.example.labreservesystem.utils.IDtoDayCourse;
import com.example.labreservesystem.utils.StringToNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookingController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BookingService bookingService;
//    @Autowired
//    private LabManagerService labManagerService;
//    @Autowired
//    private SysManagerService sysManagerService;

    /*
    确认是否预定
     */
    @GetMapping("/toBooking")
    public String toBooking(String id){
        System.out.println("收到id--->"+id);
        //插入到学生预约表中
        return "register";
    }

//    /*
//    教师预约初步信息
//     */
//    @GetMapping("/teaReserveInfo")
//    @ResponseBody
//    public ServerResponse<Boolean> teaReserveInfo(String department,String laboratory,String class_time,String trial_times,String trial_num,String trial_name){
//        try{
//            System.out.println("啦啦啦");
//            int trial_num1;
//            try{
//                trial_num1 = Integer.parseInt(trial_num);
//            }
//            catch(NumberFormatException e){
//                e.printStackTrace();
//                return ServerResponse.createByErrorMessage("失败");
//            }
//            int trial_times1 = Integer.parseInt(trial_times);
//            ReserveByTea reserveByTea = new ReserveByTea(0,false,department,laboratory,"1001",class_time,trial_name,trial_num1,trial_times1,null,null,null);
//            System.out.println(reserveByTea);
//            boolean res = bookingService.addReserveByTea(reserveByTea);
//            return ServerResponse.createBySuccess(res);
//        }
//        catch(NumberFormatException e){
//            e.printStackTrace();
//            return ServerResponse.createByErrorMessage("实验人数请输入整数！");
//        }
//        finally {
//
//        }
//    }
//    /*
//   教师预约时间段
//    */
//    @GetMapping("/teaReserveTime")
//    @ResponseBody
//    public ServerResponse teaReserveTime(@RequestParam("courseList") String courseList,String weekday){
//        try{
//            IDtoDayCourse iDtoDayCourse = new IDtoDayCourse();
//            Map<Character,String> map = iDtoDayCourse.getMap();
//            String ReserveTime[] = courseList.split(",");
//            String week = "第"+StringToNumber.parseInt(weekday).get(0).toString()+"周";
//            System.out.println(week);
//            ReserveByTea reserveByTea = bookingService.getReserveByTea("1001");
//            Boolean flag = true;
//            for(String str:ReserveTime){
//                Character c = str.charAt(0);
//                String course =  str.substring(1,2);
//                String day = map.get(c);
//                try {
//                    reserveByTea.setIsPassed(true);
//                    reserveByTea.setWeek(week);
//                    reserveByTea.setDay(day);
//                    reserveByTea.setCourse(course);
//                }
//                catch (NullPointerException e) {
//                    e.printStackTrace();
//                    return ServerResponse.createByErrorMessage("请先填写预约详情");
//                }
//                Boolean res = bookingService.addReserveByTea(reserveByTea);
//                if(!res){
//                    flag = false;
//                }
//            }
//            if(flag){
//                return ServerResponse.createBySuccess();
//            }
//            else{
//                return  ServerResponse.createByError();
//            }
//
//        }
//        finally {
//
//        }
//    }

//    /*
//   学生查看实验初步信息
//    */
//    @GetMapping("/getTrialInfo")
//    @ResponseBody
//    public ServerResponse<List<TeaAndReserve>> getTrialInfo(String stu_num){
//        try{
//            List<TeaAndReserve> teaAndReserves = new ArrayList<>();
//            List<StuAndTea> stuAndTeaList = studentService.getStuAndTea("101");
//            for(StuAndTea stuAndTea:stuAndTeaList){
//                System.out.println(stuAndTea);
//            }
//            for(StuAndTea stuAndTea:stuAndTeaList){
//                List<TeaAndReserve> teaAndReserveList = bookingService.getTeaAndReserve(stuAndTea);
//                for(TeaAndReserve teaAndReserve:teaAndReserveList){
//                        teaAndReserves.add(teaAndReserve);
////                        System.out.println(teaAndReserve);
//                }
//
//            }
//            return ServerResponse.createBySuccess(teaAndReserves);
//        }
//        catch(NumberFormatException e){
//            e.printStackTrace();
//        }
//        finally {
//
//        }
//        return null;
//    }
//    /*
//   学生预约时间段
//   */
//    @GetMapping("/stuReserveTime")
//    @ResponseBody
//    public ServerResponse stuReserveTime(@RequestParam("courseList") String courseList,String weekday,String tea_id,String department,String trial_name,String laboratory){
//        try{
//            System.out.println(courseList);
//            IDtoDayCourse iDtoDayCourse = new IDtoDayCourse();
//            Map<Character,String> map = iDtoDayCourse.getMap();
//            String ReserveTime[] = courseList.split(",");
//            String week = "第"+StringToNumber.parseInt(weekday).get(0).toString()+"周";
//            ReserveByStu reserveByStu = new ReserveByStu(null,"101",tea_id,week,null,null,department,trial_name,laboratory);
//            Boolean flag = true;
//            for(String str:ReserveTime){
//                Character c = str.charAt(0);
//                String course =  str.substring(1,2);
//                String day = map.get(c);
//                try {
//                    reserveByStu.setDay(day);
//                    reserveByStu.setCourse(course);
//                }
//                catch (NullPointerException e) {
//                    e.printStackTrace();
//                    return ServerResponse.createByErrorMessage("请先填写预约详情");
//                }
//                Boolean res = bookingService.addReserveByStu(reserveByStu);
//                if(!res){
//                    flag = false;
//                }
//            }
//            if(flag){
//                return ServerResponse.createBySuccess();
//            }
//            else{
//                return ServerResponse.createByError();
//            }
//        }
//        finally {
//
//        }
//    }

//    /*
//  预约完成，删除暂存数据
//   */
//    @PostMapping("/finishReserve")
//    @ResponseBody
//    public ServerResponse finishReserve(){
//        try{
//            System.out.println("/finishReserve");
//            Boolean res = bookingService.deleteReserveTemporary("1001");
//            if(res){
//                return ServerResponse.createBySuccess();
//            }
//            else{
//                System.out.println("删除失败");
//                return ServerResponse.createByErrorMessage("提交失败，请重新尝试！");
//
//            }
//        }
//        finally {
//
//        }
//    }

//      /*
//   教师查看学生预约状况
//   */
//    @GetMapping("/LookStuReserve")
//    @ResponseBody
//    public ServerResponse LookStuReserve(String tea_id,String trial_name){
//        try{
//            StuTeaCourse stuTeaCourse = new StuTeaCourse(null,tea_id,trial_name);
//            List<WeekDayCourse> weekDayCourseList = bookingService.getMostChoose(stuTeaCourse);
//            return ServerResponse.createBySuccess(weekDayCourseList);
//        }
//        finally {
//
//        }
//    }

//     /*
//   教师求取预约交集
//   */
//    @GetMapping("/getCross")
//    @ResponseBody
//    public ServerResponse getCross(String tea_id,String trial_name){
//        System.out.println(tea_id+" "+trial_name);
//        ReserveByTea reserveByTea = new ReserveByTea();
//        reserveByTea.setTeaId(tea_id);
//        reserveByTea.setTrialName(trial_name);
//        try{
//            List<ReservePlan> reservePlanList = bookingService.getCrossBetweenStuAndTea(reserveByTea);
//            return ServerResponse.createBySuccess(reservePlanList);
//        }
//        catch (NullPointerException e) {
//            e.printStackTrace();
//            return ServerResponse.createByError();
//        }
//
//    }
}
