package com.example.labreservesystem.web;

import ch.qos.logback.core.model.INamedModel;
import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.mapper.LabResourceMapper;
import com.example.labreservesystem.service.*;
import com.example.labreservesystem.utils.CreateWeekList;
import org.apache.commons.math3.util.Pair;
import org.springframework.stereotype.Controller;
import com.example.labreservesystem.utils.DatetoWeek;
import com.example.labreservesystem.mapper.SysManagerMapper;
import com.example.labreservesystem.bean.vo.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class UtilsController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    LabResourceService labResourceService;
    @Autowired
    BookingService bookingService;
    @Autowired
    LabManagerService labManagerService;
    @GetMapping("/getDepartmentList")
    @ResponseBody
    public ServerResponse<List<String>> GetDepartments(){
        try{
            List<Department> departments = departmentService.getAllDepartment();
            List<String> departmentList = new ArrayList<String>();
            for(Department d:departments){
                departmentList.add(d.getDept_name());
            }
//            System.out.println(departmentList);
            return ServerResponse.createBySuccess(departmentList);
        }
        finally {

        }
    }
    @GetMapping("/getWeekList")
    @ResponseBody
    public ServerResponse<List<String>> GetWeekList() throws ParseException {
        try{
            Semester semester = bookingService.getSemester("2023春季学期");
            CreateWeekList createWeekList = new CreateWeekList();
            String startDate = semester.getStart_date()+"";
            Integer weekDay = semester.getStart_weekday();
            Integer weekNum = semester.getWeek_num();
            createWeekList.getWeekList(startDate,weekDay,weekNum);
            List<String> weekList = createWeekList.getWeekList();

            return ServerResponse.createBySuccess(weekList);
        } finally {

        }
    }

    @GetMapping("/getLaboratoryList")
    @ResponseBody
    public ServerResponse<List<LabResource>> getLaboratoryList(){
        try{
            List<LabResource> labResourceList = labResourceService.getAllLaboratorys();
            return ServerResponse.createBySuccess(labResourceList);
        }
        finally {

        }

    }
    @GetMapping("/getLaboratoryListByDepartment")
    @ResponseBody
    public ServerResponse<List<String>> getLaboratoryListByDepartment(String Department){
        try{
//            System.out.println(Department);
            List<String> LabList = labResourceService.getLaboratoryByDepartment(Department);
//            System.out.println(LabList);
//            List<String> LaboratoryList = new ArrayList<>();
//            LaboratoryList.add("一号实验室");
//            LaboratoryList.add("二号实验室");
            return ServerResponse.createBySuccess(LabList);
        }
        finally {

        }
    }
    @GetMapping("/getLabManagerList")
    @ResponseBody
    public ServerResponse getLabManagerList(){
        try{
            List<LabManager> labManagerList = labManagerService.getLabManagerList();
            List<Integer> labIdList = new ArrayList<>();
            for(LabManager l:labManagerList){
                labIdList.add(l.getManager_id());
            }
            return ServerResponse.createBySuccess(labIdList);
        }
        finally {

        }

    }


}
