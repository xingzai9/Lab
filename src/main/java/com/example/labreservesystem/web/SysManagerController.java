package com.example.labreservesystem.web;

import com.example.labreservesystem.bean.po.Department;
import com.example.labreservesystem.bean.po.LabManager;
import com.example.labreservesystem.bean.po.Semester;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.ServerResponse;
import com.example.labreservesystem.service.LabManagerService;
import com.example.labreservesystem.service.StudentService;
import com.example.labreservesystem.service.SysManagerService;
import com.example.labreservesystem.service.TeacherService;
import org.etsi.uri.x01903.v13.SignerRoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/sysManager")
public class SysManagerController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private LabManagerService labManagerService;
    @Autowired
    private SysManagerService sysManagerService;
//系统管理员管理实验室管理员--------------------------------------------------------------------------------------------------------------------
    /*
    进入系统管理员查看实验室管理员信息界面
     */
    @GetMapping("/toLabManagerInfo")
    public String toManage(){
        return "SysManager/lab_manager_info";
    }
//获取实验室管理员信息
    @GetMapping("/getLabManagerList")
    @ResponseBody
    public ServerResponse getLabManagerList(Integer pageNo,Integer pageSize){
        PageUtils pageUtils = new PageUtils<>((pageNo-1)*pageSize,pageSize,null);
        List<LabManager> labManagerList = sysManagerService.getLabManagerList(pageUtils);
        Integer count = sysManagerService.getLabManagerListCount();
        return ServerResponse.createBySuccess(count+"",labManagerList);
    }


//    删除实验室管理员
    @GetMapping("/deleteLabManagerById")
    @ResponseBody
    public ServerResponse deleteLabManagerById(String manager_id){
        Boolean res = sysManagerService.deleteLabManagerById(manager_id);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }
//管理学院信息-------------------------------------------------------------------------------------------------
     /*
    进入系统管理员查看学院信息界面
     */
    @GetMapping("/toDepartmentInfo")
    public String toDepartmentInfo(){
        return "SysManager/department_info";
    }


    /*
      进入系统管理员更新学院信息弹窗
       */
    @GetMapping("/toUpdateDepartment")
    public String toUpdateDepartment(){
        return "SysManager/emp_update_department";
    }


    /*
      进入系统管理员增加学院信息弹窗
       */
    @GetMapping("/toAddDepartment")
    public String toAddDepartment(){
        return "SysManager/emp_add_department";
    }

//    获取学院信息
    @GetMapping("getDepartmentList")
    @ResponseBody
    public ServerResponse getDepartments(Integer pageNo,Integer pageSize){
        PageUtils pageUtils = new PageUtils<>((pageNo-1)*pageSize,pageSize,null);
        List<Department> departmentList = sysManagerService.getDepartmentList(pageUtils);
        Integer count = sysManagerService.getDepartmentListCount();
        return ServerResponse.createBySuccess(count+"",departmentList);
    }
//    删除学院信息
    @GetMapping("deleteDepartmentById")
    @ResponseBody
    public ServerResponse deleteDepartmentById(String dept_id){
        Boolean res = sysManagerService.deleteDepartmentById(dept_id);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }
//    更新学院信息
    @GetMapping("updateDepartmentInfo")
    @ResponseBody
    public ServerResponse updateDepartmentInfo(Integer dept_id,String dept_name,Integer dept_stu_num,Integer dept_tea_num){
        Department department = new Department(dept_id,dept_name,dept_stu_num,dept_tea_num);
        Boolean res = sysManagerService.updateDepartment(department);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }

    //   添加学院信息
    @GetMapping("addDepartment")
    @ResponseBody
    public ServerResponse addDepartment(String dept_name,Integer dept_stu_num,Integer dept_tea_num){
        Department department = new Department(null,dept_name,dept_stu_num,dept_tea_num);
        Boolean res = sysManagerService.addDepartment(department);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else {
            return ServerResponse.createByError();
        }
    }
//    管理学期信息------------------------------------------------------------------------------------------
      /*
    进入系统管理员查看学期信息界面
     */
    @GetMapping("/toSemesterInfo")
    public String toSemesterInfo(){
        return "SysManager/semester_info";
    }
//    获取学期信息
    @GetMapping("getSemester")
    @ResponseBody
    public ServerResponse getSemester(){
        Semester semester = sysManagerService.getSemester();
        return ServerResponse.createBySuccess(semester);
    }
//    更新学期，删除旧学期
    @GetMapping("updateSemester")
    @ResponseBody
    public ServerResponse updateSemester(Integer semester_id,String semester_name,String start_date,Integer start_weekday,Integer week_num) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = format.parse(start_date);
        java.sql.Date date = new java.sql.Date(date1.getTime());
        Semester semester = new Semester(semester_id,semester_name,date,start_weekday,week_num);
        Boolean res = sysManagerService.updateSemester(semester);
        if(res){
            return ServerResponse.createBySuccess();
        }
        else{
            return ServerResponse.createByError();
        }
    }
}
