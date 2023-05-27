package com.example.labreservesystem.web;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.HttpSessionImpl;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.Person;
import com.example.labreservesystem.mapper.SysManagerMapper;
import com.example.labreservesystem.service.LabManagerService;
import com.example.labreservesystem.service.StudentService;
import com.example.labreservesystem.service.SysManagerService;
import com.example.labreservesystem.service.TeacherService;
import com.example.labreservesystem.bean.vo.ServerResponse;
//import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.server.reactive.ServerHttpRequest;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/labManager")
public class ManagerController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LabManagerService labManagerService;
//管理员管理学生--------------------------------------------------------------------------------------------------------------------
    /*
    进入管理员查看学生信息界面
     */
    @GetMapping("/toStuInfo")
    public String toManage(){
        return "Manager/student_info";
    }


    /*
     进入更新学生信息界面
      */
    @GetMapping("/toUpdateStu")
    public String toUpdateStu(){
        return "Manager/emp_update_student";
    }

    /*
进入添加学生信息界面
*/
    @GetMapping("/toAddStu")
    public String toAddStu(){
        return "Manager/emp_add_student";
    }
    /*
   进入管理员查看实验室信息界面
    */

    @GetMapping("/toStudentInfo")
    @ResponseBody
    public ServerResponse<List<Student>> toStudentInfo(int pageNo, int pageSize) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        List<Student> studentList;
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        int count = studentService.getStudentCount();
        studentList = studentService.getAllStudents(map);
//        System.out.println("取了几个？"+studentList.size());
        return ServerResponse.createBySuccess("" + count, studentList);
    }

    @GetMapping("/addStudent")
    @ResponseBody
    public ServerResponse addStudent(String stu_name, String stu_num, String classroom, boolean gender, String time, String department) {
        System.out.println(stu_name + stu_num + classroom);
        try {
            Student student = new Student(null, stu_num, "123456", gender, stu_name, classroom, department, "308");
            studentService.addStudent(student);
        } finally {
            return ServerResponse.createBySuccess();
        }
    }



    @GetMapping("/deleteStudentByNum")
    @ResponseBody
    public ServerResponse deleteStudentByNum(String stu_num) {
        try {
            boolean res = studentService.deleteStudentByNum(stu_num);
            if (res) {
                return ServerResponse.createBySuccess();
            } else {
                return ServerResponse.createByError();
            }
        } finally {

        }
    }

    @GetMapping("/updateStudent")
    @ResponseBody
    public ServerResponse updateStudent(Integer id, String stu_name, String stu_num, String stu_class, boolean gender, String department, String e_mail) {
        try {
            Student student = new Student(id, stu_num, "123", gender, stu_name, stu_class, department, e_mail);
            boolean res = studentService.updateStudent(student);
            System.out.println(res);
            System.out.println(student);
            if (res) {
                return ServerResponse.createBySuccess();
            } else {
                return ServerResponse.createByError();
            }
        } finally {

        }
    }

    @GetMapping("/getStudentById")
    @ResponseBody
    public ServerResponse<Student> getStudentById(String stu_num) {
        try {
            Student student = studentService.getStudentByNum(stu_num);
            return ServerResponse.createBySuccess(student);
        } finally {

        }
    }

//管理员管理教师信息------------------------------------------------------------------------------------------------------------------------------

    /*
      进入管理员查看教师信息界面
       */
    @GetMapping("/toTeaInfo")
    public String toTeaInfo(){

        return "Manager/teacher_info";
    }



    /*
  进入更新教师信息界面
  */
    @GetMapping("/toUpdateTea")
    public String toUpdateTea(){
        return "Manager/emp_update_teacher";
    }
    /*


    /*
进入添加教师信息界面
*/
    @GetMapping("/toAddTea")
    public String toAddTea(){
        return "Manager/emp_add_teacher";
    }



    @GetMapping("/toTeacherInfo")
    @ResponseBody
    public ServerResponse<List<Teacher>> toTeacherInfo(int pageNo,int pageSize){
        try{
            Map<String,Integer> map = new HashMap<>();
            map.put("startIndex",(pageNo-1)*pageSize);
            map.put("pageSize",pageSize);
            List<Teacher> teacherList = teacherService.getAllTeacher(map);
            int count = teacherService.getTeacherCount();
            return ServerResponse.createBySuccess(""+count,teacherList);
        }
        finally {

        }
    }

    @PostMapping("/addTeacher")
    @ResponseBody
    public ServerResponse addTeacher(String tea_name,String tea_id,boolean gender,String department,String e_mail){
        try{
            Teacher teacher = new Teacher(null,tea_id,tea_name,"123",gender,department,e_mail);
            boolean res = teacherService.addTeacher(teacher);
        }
        finally {
            return ServerResponse.createBySuccess();
        }
    }

    @GetMapping("/deleteTeacherById")
    @ResponseBody
    public ServerResponse deleteTeacherById(String tea_id){
        try{
            boolean res = teacherService.deleteTeacherById(tea_id);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else {
                return ServerResponse.createByError();
            }
        }
        finally {

        }
    }
    @GetMapping("/getTeacherById")
    @ResponseBody
    public ServerResponse getTeacherById(String tea_id){
        try{
            Teacher teacher = teacherService.getTeacherById(tea_id);
            return ServerResponse.createBySuccess(teacher);
        }
        finally {

        }
    }
    @GetMapping("/updateTeacher")
    @ResponseBody
    public ServerResponse updateTeacher(Integer id,String tea_name,String tea_id,boolean gender,String department,String e_mail){
        try{
//            System.out.println(gender);
            Teacher teacher = new Teacher(id,tea_id,tea_name,null,gender,department,e_mail);
            System.out.println(teacher);
            boolean res = teacherService.updateTeacher(teacher);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else {
                return ServerResponse.createByError();
            }
        }
        finally {

        }
    }

//    管理员管理实验室-------------------------------------------------------------------------------------------------------------------------
/*
    进入更新实验室信息界面
 */
    @GetMapping("/toUpdateLab")
    public String toUpdateLab(){
        return "Manager/emp_update_lab";
    }

    /*
   进入更新教师信息界面
   */
    @GetMapping("/toAddLab")
    public String toAddLab(){
        return "Manager/emp_add_lab";
    }
    @GetMapping("/toLabInfo")
    public String toLabInfo(){
        return "Manager/lab_info";
    }

    /*
获取预约实验室信息
*/
    @GetMapping("/getLabInfo")
    @ResponseBody
    public ServerResponse getLabInfo(int pageNo, int pageSize) {
        try{
            PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,null);
            List<LabResource> labResourceList = labManagerService.getLabInfo(pageUtils);
            Integer count = labManagerService.getLabInfoCount();
            return ServerResponse.createBySuccess(""+count,labResourceList);
        }
        finally {

        }
    }

    /*
        更改实验室可用信息
    */
    @GetMapping("/changeState")
    @ResponseBody
    public ServerResponse changeState(String lab_id,Boolean can_use) {
        try{
            LabResource labResource = new LabResource();
            if(can_use == true){

                labResource.setLab_id(Integer.parseInt(lab_id));
                labResource.setCan_use(false);
                Boolean res = labManagerService.changeState(labResource);
                if(res){
                    return ServerResponse.createBySuccess();
                }
                else {
                    return ServerResponse.createByError();
                }
            }
            else if(can_use == false){
                labResource.setLab_id(Integer.parseInt(lab_id));
                labResource.setCan_use(true);
                Boolean res = labManagerService.changeState(labResource);
                if(res){
                    return ServerResponse.createBySuccess();
                }
                else {
                    return ServerResponse.createByError();
                }
            }
        }
        finally {

        }
        return ServerResponse.createByError();
    }

    @PostMapping("/addLab")
    @ResponseBody
    public ServerResponse addLab(String seat_num, String lab_name, String belong_department, String lab_manager_id) {
        System.out.println("/addLab");
        try {
            LabResource labResource = new LabResource(null,Integer.parseInt(seat_num),lab_name,belong_department,Integer.parseInt(lab_manager_id),true);
            Boolean res = labManagerService.addLab(labResource);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else {
                return ServerResponse.createByError();
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        finally {

        }
        return ServerResponse.createByError();
    }

    @GetMapping("/updateLab")
    @ResponseBody
    public ServerResponse updateLab(Integer lab_id, String seat_num, String lab_name, String belong_department, String lab_manager_id) {
        System.out.println("/updateLab");
        try {
            LabResource labResource = new LabResource(lab_id,Integer.parseInt(seat_num),lab_name,belong_department,Integer.parseInt(lab_manager_id),true);
            Boolean res = labManagerService.updateLab(labResource);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else {
                return ServerResponse.createByError();
            }
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        finally {

        }
        return ServerResponse.createByError();
    }

//    管理员功能----------------------------------------------------------------------------------------------------------
    /*
     查看预约历史界面
      */
    @GetMapping("/toReserveHistory")
    public String toReserveHistory(){
        return "Manager/show_reserve_ensure";
    }


      /*
     进入管理员预约审核界面
      */
    @GetMapping("/toReserveAudit")
    public String toReserveAudit(){
        return "Manager/show_tea_plan";
    }

    /*
    进入管理员拒绝原因界面
     */
    @GetMapping("/toRefuseReason")
    public String toRefuseReason(){
        return "Manager/emp_refuse_reason";
    }
    /*


    获取预约计划表格
     */
    @GetMapping("/getReservePlan")
    @ResponseBody
    public ServerResponse<List<ReservePlan>> getReservePlan( int pageNo, int pageSize) throws IOException {
        try{
            Map<String,Integer> map = new HashMap<>();
            map.put("startIndex",(pageNo-1)*pageSize);
            map.put("pageSize",pageSize);
            List<ReservePlan> reservePlanList = labManagerService.getReservePlan(map);
            int count = labManagerService.getReservePlanCount();
            return ServerResponse.createBySuccess(""+count,reservePlanList);
        }
        finally {

        }
    }
    /*
    管理员拒绝预约
     */
    @GetMapping("/refuseReserve")
    @ResponseBody
    public ServerResponse refuseReserve(Integer plan_id) throws IOException {
        try{
            System.out.println("/refuseReserve"+plan_id);
            Boolean res = labManagerService.setIsRefused(plan_id);
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
 管理员拒绝预约详情
  */
    @GetMapping("/refuseDetail")
    @ResponseBody
    public ServerResponse refuseDetail(HttpSession session, String reason, String text, String tea_id,String trial_name){
        try{
            System.out.println(reason+text+tea_id);
            String manager_num = (String)session.getAttribute("manager_num");
            System.out.println("/refuseDetail");
            //当前时间
            Timestamp d = new Timestamp(System.currentTimeMillis());
            Message message = new Message(null,reason,text,tea_id,manager_num,trial_name,false,d);
            labManagerService.addRefuse(message);
            return ServerResponse.createBySuccess();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        finally {

        }
        return ServerResponse.createByError();
    }


    /*
  获取预约计划表格
   */
    @GetMapping("/getReserveByDepartment")
    @ResponseBody
    public ServerResponse getReserveByDepartment(int pageNo, int pageSize,String department) throws IOException {
        try{
            System.out.println("学院 "+department+pageNo);
            PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,department);
            List<ReserveEnsure> reserveEnsureList = labManagerService.getReserveByDepartment(pageUtils);
            int count = labManagerService.getReserveEnsureCount();
            return ServerResponse.createBySuccess(""+count,reserveEnsureList);
        }
        finally {

        }
    }

    /*
获取预约计划表格
 */
    @GetMapping("/getReserveEnsure")
    @ResponseBody
    public ServerResponse getReserveEnsure(int pageNo, int pageSize) throws IOException {
        try{
            PageUtils<String> pageUtils = new PageUtils<String>((pageNo-1)*pageSize,pageSize,null);
            List<ReserveEnsure> reserveEnsureList = labManagerService.getReserveEnsure(pageUtils);
            int count = labManagerService.getReserveEnsureCount();

            return ServerResponse.createBySuccess(""+count,reserveEnsureList);
        }
        finally {

        }
    }



    /*
    删除确认预约信息
    */
    @GetMapping("/deleteReserveByEnsureId")
    @ResponseBody
    public ServerResponse deleteReserveByEnsureId(String ensure_id) throws IOException {
        try{
            Boolean res = labManagerService.deleteReserveById(ensure_id);
            if(res){
                return ServerResponse.createBySuccess();
            }
            else{
                return ServerResponse.createByErrorMessage("删除失败");
            }

        }
        finally {

        }
    }


    /*
   管理员确认预约
    */
    @GetMapping("/ensureReserve")
    @ResponseBody
    public ServerResponse getReservePlan(Integer plan_id){
        try{
            //获取plan_id的plan
            ReservePlan reservePlan = labManagerService.getPlanById(plan_id);
            Timestamp d = new Timestamp(System.currentTimeMillis());
            String belong_department = reservePlan.getDepartment();
            String laboratory = reservePlan.getLaboratory();
            String week = reservePlan.getReserve_week();
            String day = reservePlan.getReserve_day();
            String course = reservePlan.getReserve_course();
            Integer trial_num = reservePlan.getTrial_num();
            String trial_name = reservePlan.getTrial_name();
            String tea_id = reservePlan.getReserve_tea_id();
            ReserveEnsure reserveEnsure = new ReserveEnsure(null,week,day,course,
            laboratory,trial_num, null,trial_name,tea_id,belong_department, d);
            List<ReserveEnsure> reserveEnsureList = labManagerService.getReserveEnsureSame(reserveEnsure);
            if(reserveEnsureList.isEmpty()){
                Boolean resInsert = labManagerService.addReserveEnsure(reserveEnsure);
                //把plan-id的数据删除
                Boolean resDelete = labManagerService.deleteById(plan_id);
                if(resDelete && resInsert){
                    return ServerResponse.createBySuccess();
                }
                else{
                    return ServerResponse.createByErrorMessage("插入或删除失败");
                }
            }
            else{
                return ServerResponse.createByErrorMessage("该实验室该时间段已经被预约使用，请退回教师重新选择实验室或时段");
            }

        }
        finally {

        }
    }

}
