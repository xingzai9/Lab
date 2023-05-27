package com.example.labreservesystem.web;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.bean.vo.WeekDayCourse;
import com.example.labreservesystem.mapper.SysManagerMapper;
import com.example.labreservesystem.service.*;
import com.example.labreservesystem.bean.vo.ServerResponse;
import com.example.labreservesystem.utils.DayCoursetoID;
import com.example.labreservesystem.utils.IDtoDayCourse;
import com.example.labreservesystem.utils.StringToNumber;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tea")
public class TeacherController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    BookingService bookingService;

//    管理信息-------------------------------------------------------------------------------------------------


    /*
    实验检测
     */
    @GetMapping("/toTeacher")
    public String Login() throws IOException {
        System.out.println("/toTeacher");
        return "teacher";
    }

    /*
  前往修改个人信息页面
   */
    @GetMapping("/toModifyInfo")
    public String toModifyInfo() throws IOException {
        return "Teacher/tea_modify_info";
    }

    /*
进入我的消息界面
 */
    @GetMapping("/toMyMessage")
    public String toMyMessage(){
        return "Teacher/look_my_message";
    }

    /*
      教师删除消息
   */
    @GetMapping("/deleteMessage")
    @ResponseBody
    public ServerResponse deleteMessage(Integer id) {
        Boolean res = teacherService.deleteMessage(id);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }
    //    教师获取实验课程信息
    @GetMapping("/getTrialList")
    @ResponseBody
    public ServerResponse getTrialList(HttpSession session){
        String tea_num = (String) session.getAttribute("tea_num");
        List<String> trialList = teacherService.getAllTrial(tea_num);
        return ServerResponse.createBySuccess(trialList);
    }

    /*
获取我的信息
*/
    @GetMapping("/getMyMessage")
    @ResponseBody
    public ServerResponse getMyMessage(HttpSession session,Integer pageNo, Integer pageSize){
        try{
            String tea_id = (String)session.getAttribute("tea_num");
            Integer count = teacherService.getMyMessageCount(tea_id);
            PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,tea_id);
            List<Message> messageList = teacherService.getMyMessage(pageUtils);
            Boolean res = teacherService.changeIsRead(tea_id);
            if(res && !messageList.isEmpty()){
                return ServerResponse.createBySuccess(count+"",messageList);
            }
            else{
                return ServerResponse.createByError();
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        finally {

        }
        return ServerResponse.createByError();
    }
    /*
          获取后端传递的session信息
           */
    @GetMapping("/getSession")
    @ResponseBody
    public ServerResponse<String> ToReserve(HttpSession session) throws IOException {
        String username = (String)session.getAttribute("tea_num");
        System.out.println("/getSession"+username);
        return ServerResponse.createBySuccess(username);
    }

    /*
教师获取自己学生信息
*/
    @GetMapping("/getMyStudent")
    @ResponseBody
    public ServerResponse getMyStudent(HttpSession session, Integer pageNo, Integer pageSize, String trial_name) {
        Map<String,String> map = new HashMap<>();
        String tea_num = (String) session.getAttribute("tea_num");
        if(trial_name == null)
            trial_name = "c++程序设计";
        map.put("tea_id",tea_num);
        map.put("trial_name",trial_name);
        Integer count = teacherService.getMyStudentCount(tea_num);
        PageUtils<Map<String,String>> pageUtils = new PageUtils<Map<String, String>>((pageNo-1)*pageSize,pageSize,map);
        List<Student> studentList = teacherService.getMyStudent(pageUtils);
        return ServerResponse.createBySuccess(count+"",studentList);
    }

    /*
教师删除自己学生信息
*/
    @GetMapping("/deleteMyStudent")
    @ResponseBody
    public ServerResponse deleteMyStudent(HttpSession session, String stu_num,String trial_name) {
        String tea_num = (String) session.getAttribute("tea_num");
        System.out.println("/deleteMyStudent");
        StuTeaCourse stuTeaCourse = new StuTeaCourse(stu_num,tea_num, trial_name);
//        System.out.println(stuTeaCourse);
        Boolean res = teacherService.deleteMyStudent(stuTeaCourse);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }


//预约相关-------------------------------------------------------------------------------------------------------


    /*
    前往初步预约页面
     */
    @GetMapping("/toReserve")
    public String toReserve() throws IOException {
        System.out.println("/toReserve");
        return "Teacher/tea_booking_pre";
    }

    /*
       填写预约信息弹窗
        */
    @GetMapping("/toTrialInfo")
    public String toTrialInfo() {
        System.out.println("/toTrialInfo");
        return "Teacher/emp_trial_info";
    }

    /*
   前往预约详情页面
    */
    @GetMapping("/toReserveDetail")
    public String toReserveDetail(Model model,String department,String laboratory) throws IOException {
        model.addAttribute("department",department);
        model.addAttribute("laboratory",laboratory);
        System.out.println("/toReserveDetail"+department+laboratory);
        System.out.println("/toReserveDetail");
        return "Teacher/tea_booking";
    }

    //    获取已经被选中的课
    @GetMapping("/getHoldCourseList")
    @ResponseBody
    public ServerResponse getHoldCourseList(Model model,String week,String department,String laboratory){
//        String department = (String) model.getAttribute("department");
//        String laboratory = (String) model.getAttribute("laboratory");
        ReserveEnsure reserveEnsure = new ReserveEnsure();
        week = "第" + StringToNumber.parseInt(week).get(0).toString() + "周";
        System.out.println("/getHoldCourseList"+department+laboratory+week);
        reserveEnsure.setWeek(week);
        reserveEnsure.setDepartment(department);
        reserveEnsure.setLaboratory(laboratory);
        DayCoursetoID dayCoursetoID = new DayCoursetoID();
        List<ReserveEnsure> reserveEnsureList = teacherService.getHoldCourse(reserveEnsure);
        List<String> strings = new ArrayList<>();
        for(ReserveEnsure r:reserveEnsureList){
            String w = r.getWeek();
            String d = r.getDay();
            String course = r.getCourse();
            Character c = dayCoursetoID.getMap().get(d);
            String res = c+course;
            strings.add(res);
            System.out.println(r);
        }
        return ServerResponse.createBySuccess(strings);
    }
    /*
   前往我的实验预约页面
    */
    @GetMapping("/toMyTrial")
    public String toMyTrial() throws IOException {
        System.out.println("/toMyTrial");
        return "Teacher/show_my_trial";
    }


    /*
        前往选择最终预约页面
    */
    @GetMapping("/toDecideReserve")
    public String toDecideReserve(Model model,String trial_name) {
        trial_name = trial_name.replace(' ','+');
        model.addAttribute("trial_name",trial_name);
        System.out.println("/toDecideReserve");
        return "Teacher/decide_reserve";
    }

    /*
       前往预约详情页面
   */
    @GetMapping("/toLookTeaReserve")
    public String toLookTeaReserve() {
        System.out.println("/toLookTeaReserve");
        return "Teacher/look_my_reserve";
    }

    /*
  前往学生预约页面
   */
    @GetMapping("/toLookStuReserve")
    public String toLookStuReserve() {
        System.out.println("/toLookStuReserve");
        return "Teacher/look_stuReserveInfo";
    }

    /*
   前往最佳预约求取页面
   */
    @GetMapping("/toMostValueReserve")
    public String toMostValueReserve(){
        System.out.println("/toMostValueReserve");
        return "Teacher/decide_reserve";
    }


    /*
 前往预约详情页面
  */
    @GetMapping("/toMyStudent")
    public String toMyStudent() {
        System.out.println("/toMyStudent");
        return "Teacher/show_my_student";
    }


        /*
    前往实验室选择界面
    */
    @GetMapping("/toLabChoose")
    public String toLabChoose() {
        System.out.println("/toLabChoose");
        return "Teacher/emp_lab_choose";
    }

    /*
  前往预约详情页面
   */
    @GetMapping("/toReserveRecord")
    public String toReserveRecord() throws IOException {
        System.out.println("/toReserveRecord");
        return "Teacher/show_reserve_record";
    }

    /*
 教师得到自身预约信息
  */
    @GetMapping("/getReserveRecordById")
    @ResponseBody
    public ServerResponse getReserveRecordById(HttpSession session, Integer pageNo, Integer pageSize) {
        String tea_num = (String) session.getAttribute("tea_num");
        PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,tea_num);
        Integer count = teacherService.getReserveRecordByIdCount(tea_num);
        List<ReserveEnsure> reserveEnsureList = teacherService.getReserveRecordById(pageUtils);
        return ServerResponse.createBySuccess(count+"",reserveEnsureList);
    }


    /*
教师得到自身预约信息
*/
    @GetMapping("/getReserveByTeaById")
    @ResponseBody
    public ServerResponse getReserveByTeaById(HttpSession session, Integer pageNo, Integer pageSize) {
        String tea_num = (String) session.getAttribute("tea_num");
        PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,tea_num);
        List<ReserveByTea> reserveByTeaList = teacherService.getReserveByTeaById(pageUtils);
        Integer count = teacherService.getReserveByTeaByIdCount(pageUtils);
        return ServerResponse.createBySuccess(count+"",reserveByTeaList);
    }

    /*
教师删除自身预约信息
 */
    @GetMapping("/deleteReserveRecordById")
    @ResponseBody
    public ServerResponse deleteReserveRecordById(String ensure_id) {
        Boolean res = teacherService.deleteReserveRecordById(ensure_id);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }



    /*
教师删除reserveByTea信息
*/
    @GetMapping("/deleteReserveByTea")
    @ResponseBody
    public ServerResponse deleteReserveByTea(HttpSession session, String trial_name,String week,String day,String course) {
        System.out.println("/deleteReserveByTea");
        String tea_num = (String) session.getAttribute("tea_num");
        ReserveByTea reserveByTea = new ReserveByTea(null,true,null,null,tea_num,null,trial_name,null,null,week,day,course);
        System.out.println(reserveByTea);
        Boolean res1 = teacherService.deleteMyReservePlan(reserveByTea);
        Boolean res2 = studentService.deleteReserveByStu(reserveByTea);
        if(res1 && res2){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }

    /*
教师删除reserveByTea信息
*/
    @GetMapping("/deleteReserveByTeaById")
    @ResponseBody
    public ServerResponse deleteReserveByTeaById(String reserveByTea_id) {
        Boolean res = teacherService.deleteReserveByTeaById(reserveByTea_id);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }

    /*
 教师得到自身课程名称
 */
    @GetMapping("/getTrialNameList")
    @ResponseBody
    public ServerResponse teaTrialNameList(HttpSession session) {
        String tea_num = (String) session.getAttribute("tea_num");
        List<String> trialNameList = teacherService.getTrialNameList(tea_num);
        return ServerResponse.createBySuccess(trialNameList);
    }



    /*
教师得到自身课程信息
*/
    @GetMapping("/getMyTrial")
    @ResponseBody
    public ServerResponse getMyTrial(HttpSession session, Integer pageNo,Integer pageSize) {
        String tea_num = (String) session.getAttribute("tea_num");
        Integer count = teacherService.getMyTrialCount(tea_num);
        PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,tea_num);
        List<TeaStuSemester> teaStuSemesterList = teacherService.getMyTrial(pageUtils);
        return ServerResponse.createBySuccess(count+"",teaStuSemesterList);
    }

    /*
教师得到自身预约推荐实验室
*/
    @GetMapping("/getRecommendLaboratory")
    @ResponseBody
    public ServerResponse getRecommendLaboratory(String trial_name,String department,
        String laboratory,Integer trial_num,String week,String day,String course) {
        ReserveEnsure reserveEnsure = new ReserveEnsure();
        reserveEnsure.setDepartment(department);
        reserveEnsure.setLaboratory(laboratory);
        reserveEnsure.setTrial_num(trial_num);
        reserveEnsure.setWeek(week);
        reserveEnsure.setDay(day);
        reserveEnsure.setCourse(course);
        List<LabResource> labResourceList = teacherService.getRecommendLaboratory(reserveEnsure);
        for(LabResource labResource:labResourceList){
            System.out.println(labResource);
        }
        return ServerResponse.createBySuccess(labResourceList);
    }


    /*
    教师删除自身课程信息
*/
    @GetMapping("/deleteMyTrial")
    @ResponseBody
    public ServerResponse deleteMyTrial(HttpSession session, String semester, String trial_name ) {
        String tea_id = (String)session.getAttribute("tea_num");
        System.out.println(tea_id+semester+trial_name);
        TeaStuSemester teaStuSemester = new TeaStuSemester(null,null,tea_id,semester,trial_name);
        Boolean res = teacherService.deleteMyTrial(teaStuSemester);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }
    /*
  教师预约初步信息
   */
    @GetMapping("/teaReserveInfo")
    @ResponseBody
    public ServerResponse<Boolean> teaReserveInfo(HttpSession session, String department,String laboratory,String class_time,String trial_times,String trial_num,String trial_name){
        try{
            System.out.println("啦啦啦");
            int trial_num1;
            try{
                trial_num1 = Integer.parseInt(trial_num);
            }
            catch(NumberFormatException e){
                e.printStackTrace();
                return ServerResponse.createByErrorMessage("失败");
            }
            int trial_times1 = Integer.parseInt(trial_times);
            String tea_num = (String) session.getAttribute("tea_num");
            ReserveByTea reserveByTea = new ReserveByTea(0,false,department,laboratory,tea_num,class_time,trial_name,trial_num1,trial_times1,null,null,null);
//            System.out.println(reserveByTea);
            boolean res = bookingService.addReserveByTea(reserveByTea);
            return ServerResponse.createBySuccess(res);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("实验人数请输入整数！");
        }
        finally {

        }
    }
    /*
 预约完成，删除暂存数据
  */
    @PostMapping("/finishReserve")
    @ResponseBody
    public ServerResponse finishReserve(HttpSession session){
        try{
            String tea_num = (String) session.getAttribute("tea_num");
            System.out.println("/finishReserve");
            Boolean res = bookingService.deleteReserveTemporary(tea_num);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else{
                System.out.println("删除失败");
                return ServerResponse.createByErrorMessage("提交失败，请重新尝试！");

            }
        }
        finally {

        }
    }



    /*
 教师预约时间段
  */
    @GetMapping("/teaReserveTime")
    @ResponseBody
    public ServerResponse teaReserveTime(HttpSession session, @RequestParam("courseList") String courseList,String weekday){
        try{
            IDtoDayCourse iDtoDayCourse = new IDtoDayCourse();
            Map<Character,String> map = iDtoDayCourse.getMap();
            String ReserveTime[] = courseList.split(",");
            String week = "第"+ StringToNumber.parseInt(weekday).get(0).toString()+"周";
            System.out.println(week);
            //需要使用session或者cookie
            String tea_num = (String) session.getAttribute("tea_num");

            ReserveByTea reserveByTea = bookingService.getReserveByTea(tea_num);
//            System.out.println(reserveByTea);
            List<ReserveByTea> reserveByTeaList = bookingService.getReserveByTeaList(reserveByTea);

            Boolean flag = true;
            for(String str:ReserveTime){
                Character c = str.charAt(0);
                String course =  str.substring(1,2);
                String day = map.get(c);
                for(ReserveByTea r:reserveByTeaList){
                    if(week.equals(r.getWeek()) && day.equals(r.getDay()) && course.equals(r.getCourse())){
                        return ServerResponse.createByErrorMessage("已经提交，请勿重复提交");
                    }
                }
                try {
                    reserveByTea.setIs_passed(true);
                    reserveByTea.setWeek(week);
                    reserveByTea.setDay(day);
                    reserveByTea.setCourse(course);
                }
                catch (NullPointerException e) {
                    e.printStackTrace();
                    return ServerResponse.createByErrorMessage("请先填写预约详情");
                }
                Boolean res = bookingService.addReserveByTea(reserveByTea);
                if(!res){
                    flag = false;
                }
            }
            if(flag){
                return ServerResponse.createBySuccess();
            }
            else{
                return  ServerResponse.createByError();
            }

        }
        finally {

        }
    }


    /*
    教师查看学生预约状况
    */
    @GetMapping("/LookStuReserve")
    @ResponseBody
    public ServerResponse LookStuReserve(HttpSession session, String trial_name){
        try{
            String tea_num = (String) session.getAttribute("tea_num");
            StuTeaCourse stuTeaCourse = new StuTeaCourse(null,tea_num,trial_name);
            List<WeekDayCourse> weekDayCourseList = bookingService.getMostChoose(stuTeaCourse);
            return ServerResponse.createBySuccess(weekDayCourseList);
        }
        finally {

        }
    }

    /*
   教师提交预约计划
   */
    @GetMapping("/addReservePlan")
    @ResponseBody
    public ServerResponse addReservePlan(HttpSession session,String trial_name,Integer trial_num,
                                         String week,String day,String course,String department,
                                         String laboratory){
        try{
            System.out.println("/addReservePlan");
            String tea_id = (String) session.getAttribute("tea_num");
            ReservePlan reservePlan = new ReservePlan(0,day,week,course,trial_num,trial_name,null,false,null,tea_id,laboratory,department);
            Boolean res = teacherService.addReservePlan(reservePlan);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else{
                return ServerResponse.createByError();
            }
        }
        finally {

        }
    }

    /*
  教师求取预约交集
  */
    @GetMapping("/getCross")
    @ResponseBody
    public ServerResponse getCross(HttpSession session,String trial_name){
        String tea_num = (String) session.getAttribute("tea_num");
        System.out.println(tea_num+" "+trial_name+"/getCross");
        ReserveByTea reserveByTea = new ReserveByTea();
        reserveByTea.setTea_id(tea_num);
        reserveByTea.setTrial_name(trial_name);
        try{
            List<ReservePlan> reservePlanList = bookingService.getCrossBetweenStuAndTea(reserveByTea);
            return ServerResponse.createBySuccess(reservePlanList);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return ServerResponse.createByError();
        }

    }

}
