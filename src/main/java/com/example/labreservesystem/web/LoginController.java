package com.example.labreservesystem.web;

import com.example.labreservesystem.bean.po.LabManager;
import com.example.labreservesystem.bean.po.Student;
import com.example.labreservesystem.bean.po.Teacher;
import com.example.labreservesystem.mapper.SysManagerMapper;
import com.example.labreservesystem.service.LabManagerService;
import com.example.labreservesystem.service.StudentService;
import com.example.labreservesystem.service.SysManagerService;
import com.example.labreservesystem.service.TeacherService;
import com.example.labreservesystem.bean.vo.ServerResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.server.reactive.ServerHttpRequest;
import java.io.IOException;
import org.springframework.http.server.reactive.ServerHttpRequest;
import java.util.List;
//@EnableRedisHttpSession
@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
//    @Autowired
//    private HttpSession session;
    @Autowired
    private LabManagerService labManagerService;
    /*
    前往注册页面
     */
    @GetMapping("/toRegister")
    public String toRegister() throws IOException {
        System.out.println("/toRegister");
        return "register";
    }
    /*
    登录方法
     */
    @GetMapping("/toLogin")
    public String toLogin() throws IOException {
        System.out.println("/toLogin");
        return "index";
    }
    @GetMapping("/login")
    @ResponseBody
    public ServerResponse login(String userName, String password, String role,HttpSession session
    ) throws IOException {
//        session.setAttribute("username",userName);
//        session.s;
        //role 0学生 1教师 2实验室管理员 3系统管理员
        if(role.equals("0")){//学生
            Student student = studentService.getStudentByNum(userName);
            if(student!=null && student.getStu_password().equals(password)){
                System.out.println(userName);
                session.setAttribute("stu_num",userName);//学号
                session.setAttribute("stu_password",password);
//                session.setAttribute("role",role);
                return ServerResponse.createBySuccessMessage("stu");
            }
            else{
                return ServerResponse.createByErrorMessage("用户名或密码错误");
            }
        }
        else if(role.equals("1")){//教师
            Teacher teacher = teacherService.getTeacherById(userName);
            if(teacher!=null && teacher.getTea_password().equals(password)){
                session.setAttribute("tea_num",userName);//学号
                session.setAttribute("tea_password",password);
                return ServerResponse.createBySuccessMessage("tea");
            }
            else{
                return ServerResponse.createByErrorMessage("用户名或密码错误");
            }
        }
        else if(role.equals("2")){
            //实验室管理员
            LabManager labManager = labManagerService.getManagerByNum(userName);
            if(labManager!=null && labManager.getManager_password().equals(password)){
                //                session.setAttribute("role);
                session.setAttribute("manager_num",userName);//学号
                session.setAttribute("manager_password",password);
                return ServerResponse.createBySuccessMessage("labManager");
            }
            else {
                return ServerResponse.createByErrorMessage("用户名或密码错误");
            }

        }
        else if(role.equals("3"))//系统管理员
        {
            session.setAttribute("sys_num",userName);//学号
            session.setAttribute("sys_password",password);
            return ServerResponse.createBySuccessMessage("sysManager");
        }
        else{
            return ServerResponse.createBySuccessMessage("fail");
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
//        session.removeAttribute("stu_num");

        if (session.getAttribute("stu_num")!=null){
            session.removeAttribute("stu_num");
            session.removeAttribute("stu_password");
        }else if (session.getAttribute("tea_num")!=null){
            session.removeAttribute("tea_num");
            session.removeAttribute("tea_password");
        }else if (session.getAttribute("manager_num")!=null){
            session.removeAttribute("manager_num");
            session.removeAttribute("manager_password");
        }
        else if(session.getAttribute("sys_num")!=null){
            session.removeAttribute("sys_num");
            session.removeAttribute("sys_password");
        }
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/register")
    @ResponseBody
    public ServerResponse<String> register(String userNum,String e_mail,String password,String role){
        if (role.equals("0")){
            Student student1 = studentService.getStudentByNum(userNum);
            if(student1 == null){//找不到这个学生才能注册
                Student student = new Student(null,userNum,password,false,null,null,null,e_mail);
                boolean res = studentService.addStudent(student);
                if(res){
                    return ServerResponse.createBySuccessMessage("stu");
                }
                else{
                    return ServerResponse.createByErrorMessage("系统故障,请重新尝试");
                }
            }
            else {
                return ServerResponse.createByErrorMessage("用户已被注册，请联系管理员");
            }
        }
        if (role.equals("1")){
            Teacher teacher1 = teacherService.getTeacherById(userNum);
            if(teacher1 == null){
                Teacher teacher = new Teacher(null,userNum,null,password,false,null,e_mail);
                boolean res = teacherService.addTeacher(teacher);
                if(res){
                    return ServerResponse.createBySuccessMessage("tea");
                }
                else{
                    return ServerResponse.createByError();
                }
            }
            else {
                return ServerResponse.createByErrorMessage("用户已被注册，请联系管理员");
            }
        }

        return ServerResponse.createByErrorMessage("注册失败");
    }
}
