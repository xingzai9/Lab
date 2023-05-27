package com.example.labreservesystem.web;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.Person;
import com.example.labreservesystem.bean.vo.TeaAndReserve;
import com.example.labreservesystem.mapper.SysManagerMapper;
import com.example.labreservesystem.service.*;
import com.example.labreservesystem.bean.vo.ServerResponse;
import com.example.labreservesystem.utils.IDtoDayCourse;
import com.example.labreservesystem.utils.StringToNumber;
import com.example.labreservesystem.utils.WeektoDate;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.standard.Severity;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BookingService bookingService;

    /*
    前往预约选择页面
     */
    @GetMapping("/toReserve")
    public String ToReserve(HttpSession session, Model model) throws IOException {
        System.out.println("/toReserve");
        String username = (String)session.getAttribute("stu_num") ;
        model.addAttribute("username",username);
        return "Student/show_CanReserve";
    }
    /*
      前往预约详情页面
       */
    @GetMapping("/toReserveDetail")
    public String ToReserveDetail(Model model, String tea_id, String trial_name, String department,String laboratory) throws IOException {
        model.addAttribute("tea_id",tea_id);
        trial_name = trial_name.replace(' ','+');
        model.addAttribute("trial_name",trial_name);
        model.addAttribute("department",department);
        model.addAttribute("laboratory",laboratory);
        System.out.println("/toReserveDetail"+tea_id+trial_name+department+laboratory);
        return "Student/stu_booking";
    }

    /*
     前往个人信息维护页面
      */
    @GetMapping("/toModifyInfo")
    public String toModifyInfo() throws IOException {
        return "Student/stu_modify_info";
    }

    /*
     前往修改密码弹窗
      */
    @GetMapping("/toChangePassword")
    public String toChangePassword() throws IOException {
        return "Student/stuPassword_emp";
    }
    /*
     返回密码给前端
      */
    @GetMapping("/getPassword")
    @ResponseBody
    public ServerResponse<String> getPassword(HttpSession session) throws IOException {
        String stu_password = (String)session.getAttribute("stu_password");
        return ServerResponse.createBySuccess(stu_password);
    }

    /*
 前往预约选择页面
  */
    @GetMapping("/toReserveRecord")
    public String toReserveRecord() throws IOException {
        System.out.println("来到后端toReserveRecord---");
        return "Student/show_reserve_record";
    }

    /*
前往我的教师界面
*/
    @GetMapping("/toMyTeacher")
    public String toMyTeacher() throws IOException {
        System.out.println("/toMyTeacher");
        return "Student/show_my_teacher";
    }


    /*
      修改密码
       */
    @GetMapping("/changePassword")
    @ResponseBody
    public ServerResponse changePassword(HttpSession session, String oldPass, String newPass, String reNewPass) throws IOException {
        String stu_password = (String)session.getAttribute("stu_password");
        String stu_num = (String)session.getAttribute("stu_num");
        System.out.println(stu_num+stu_password);
        Student student = new Student();
        student.setStu_num(stu_num);
        student.setStu_password(newPass);
        Boolean res = studentService.changePassword(student);
        if (res) {
            return ServerResponse.createBySuccess();
        }
        else{
            return ServerResponse.createByError();
        }
    }

    /*
       获取后端传递的session信息
        */
    @GetMapping("/getSession")
    @ResponseBody
    public ServerResponse<String> ToReserve(HttpSession session) throws IOException {
        String username = (String)session.getAttribute("stu_num");
        System.out.println("/getSession"+username);
        return ServerResponse.createBySuccess(username);
    }

    /*
    获取预约记录
    */
    @GetMapping("/getReserveRecord")
    @ResponseBody
    public ServerResponse getReserveRecord(HttpSession session,Integer pageNo,Integer pageSize) throws IOException {
        System.out.println("/getReserveRecord");
        String stu_num = (String)session.getAttribute("stu_num");
        PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,stu_num);
        try{
            Integer count = studentService.getReserveRecordCount(stu_num);
            List<ReserveByStu> reserveByStus = studentService.getReserveRecord(pageUtils);
            return ServerResponse.createBySuccess(count+"",reserveByStus);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return ServerResponse.createByError();
    }


    /*
      删除预约记录by-id
      */
    @GetMapping("/deleteReserveById")
    @ResponseBody
    public ServerResponse deleteReserveById(String id) throws IOException {
        System.out.println(id);
        Boolean res = studentService.deleteReserveById(id);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else{
            return ServerResponse.createByError();
        }
    }


    //获取我的教师信息
    @GetMapping("/getMyTeacher")
    @ResponseBody
    public ServerResponse getMyTeacher(HttpSession session,Integer pageNo, Integer pageSize, String trial_name) {
        try {
            String stu_num = (String) session.getAttribute("stu_num");
            System.out.println("/getMyTeacher");
            PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,stu_num);
            List<Teacher> teacherList = studentService.getMyTeacher(pageUtils);
            for(Teacher teacher : teacherList){
                System.out.println(teacher);
            }
            Integer count = studentService.getMyTeacherCount(pageUtils);
            return ServerResponse.createBySuccess(count+"",teacherList);
        } finally {

        }
    }

       /*
   学生查看实验初步信息
    */
    @GetMapping("/getTrialInfo")
    @ResponseBody
    public ServerResponse<List<TeaAndReserve>> getTrialInfo(HttpSession session){
        try{

            String stu_num = (String) session.getAttribute("stu_num");
            System.out.println("/getTrialInfo"+stu_num);
            List<TeaAndReserve> teaAndReserves = new ArrayList<>();
            List<StuAndTea> stuAndTeaList = studentService.getStuAndTea(stu_num);
//            for(StuAndTea stuAndTea:stuAndTeaList){
//                System.out.println(stuAndTea);
//            }
            for(StuAndTea stuAndTea:stuAndTeaList){
                List<TeaAndReserve> teaAndReserveList = bookingService.getTeaAndReserve(stuAndTea);
                for(TeaAndReserve teaAndReserve:teaAndReserveList){
                    teaAndReserves.add(teaAndReserve);
//                        System.out.println(teaAndReserve);
                }

            }
            return ServerResponse.createBySuccess(teaAndReserves);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
        finally {

        }
        return null;
    }
      /*
   学生预约时间段
   */
    @GetMapping("/stuReserveTime")
    @ResponseBody
    public ServerResponse stuReserveTime(HttpSession session, @RequestParam("courseList") String courseList,String week,String tea_id,String department,String trial_name,String laboratory){
        if(courseList.equals("")){
            return ServerResponse.createByErrorMessage("请先选择课程");
        }
        else if(week.equals("")){
            return ServerResponse.createByErrorMessage("请先选择周次");
        }
        try{
            String stu_num = (String) session.getAttribute("stu_num");
            System.out.println("/stuReserveTime"+stu_num+courseList+week+tea_id+laboratory+department+trial_name);
            System.out.println(courseList);
            IDtoDayCourse iDtoDayCourse = new IDtoDayCourse();
            Map<Character,String> map = iDtoDayCourse.getMap();
            String ReserveTime[] = courseList.split(",");
            String week1 = "";
            try {
                week1 = "第"+StringToNumber.parseInt(week).get(0).toString()+"周";
            }
            catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
            ReserveByStu reserveByStu = new ReserveByStu(null,stu_num,tea_id,week1,null,null,department,trial_name,laboratory);
            Boolean flag = true;
            for(String str:ReserveTime){
                Character c = str.charAt(0);
                String course =  str.substring(1,2);
                String day = map.get(c);
                try {
                    reserveByStu.setDay(day);
                    reserveByStu.setCourse(course);
                }
                catch (NullPointerException e) {
                    e.printStackTrace();
                    return ServerResponse.createByErrorMessage("请先填写预约详情");
                }
//搜索查看是否已经插入过此条信息
                List<ReserveByStu> reserveByStus = bookingService.getReserveByStuSame(reserveByStu);
                if(reserveByStus.isEmpty()){
                    Boolean res = bookingService.addReserveByStu(reserveByStu);
                }
                else {
                    flag = false;
                }
            }
            if(flag){
                return ServerResponse.createBySuccess("插入成功");
            }
            else{
                return ServerResponse.createByErrorMessage("已经提交请勿重复提交");
            }
        }
        finally {

        }
    }
    //学生获取可选择周数
    //教师id获取不到
    //课程名获取不到
    @GetMapping("/stuWeekList")
    @ResponseBody
    public ServerResponse stuWeekList(HttpSession session, String tea_id,String trial_name) {
        try {
            String stu_num = (String) session.getAttribute("stu_num");
            System.out.println(tea_id + " " + trial_name);
            WeektoDate weektoDate = new WeektoDate();
            StuAndTea stuAndTea = new StuAndTea(null, stu_num, tea_id, "2023春季学期",trial_name);
            List<ReserveByTea> reserveByTeaList = teacherService.getReserveByTea(stuAndTea);
            List<String> weekList = new ArrayList<>();
            for(ReserveByTea reserveByTea:reserveByTeaList){
                String week = reserveByTea.getWeek();
                List<Integer> weekOrders = StringToNumber.parseInt(week);
                Integer weekOrder = weekOrders.get(0);
                String[] strings = weektoDate.WToD(weekOrder-1,"2023-02-20");
                String time = week + "          " + strings[0] + "————" + strings[1];
                if(!weekList.contains(time)){
                    weekList.add(time);
                }
            }
            Collections.sort(weekList);
            return ServerResponse.createBySuccess(weekList);
        } finally {

        }
    }


    /*
    学生修改信息
     */

    @GetMapping("/modifyInfo")
    @ResponseBody
    public ServerResponse modifyInfo(HttpSession session,String tea_id,String trial_name) {
        try {
            String stu_num = (String) session.getAttribute("stu_num");
            System.out.println("/modifyInfo"+stu_num);
            WeektoDate weektoDate = new WeektoDate();
            StuAndTea stuAndTea = new StuAndTea(null, stu_num, tea_id, "2023春季学期",trial_name);
            List<ReserveByTea> reserveByTeaList = teacherService.getReserveByTea(stuAndTea);
            List<String> weekList = new ArrayList<>();
            for(ReserveByTea reserveByTea:reserveByTeaList){
                String week = reserveByTea.getWeek();
                List<Integer> weekOrders = StringToNumber.parseInt(week);
                Integer weekOrder = weekOrders.get(0);
                String[] strings = weektoDate.WToD(weekOrder-1,"2023-02-20");
                String time = week + "          " + strings[0] + "————" + strings[1];
                if(!weekList.contains(time)){
                    weekList.add(time);
                }
            }
            Collections.sort(weekList);
            return ServerResponse.createBySuccess(weekList);
        } finally {

        }
    }


}
