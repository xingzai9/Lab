package com.example.labreservesystem.web;

import com.example.labreservesystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    ExcelService excelService;

    //打开upload页面
    @RequestMapping("/toImportStudent")
    public String toImportStudent() {
        return "/Manager/uploadStudent";
    }

    //实现批量倒入
    @RequestMapping("/importStudentExcel")
    @ResponseBody
    public String importExcelTable(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println("文件开始上传");
        int count = excelService.insertStuExcelData(multipartFile);
        if (count > 0) {
            return "success";
        } else {
            return "fail";
        }
    }


    //打开upload页面
    @RequestMapping("/toImportTeacher")
    public String toImportTeacher() {
        return "/Manager/uploadTeacher";
    }

    //实现批量倒入
    @RequestMapping("/importTeacherExcel")
    @ResponseBody
    public String importTeacherExcel(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println("文件开始上传");
        int count = excelService.insertTeaExcelData(multipartFile);
        if (count > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    //打开upload页面
    @RequestMapping("/toImportTrial")
    public String toImportTrial() {
        return "/Manager/uploadTrial";
    }

    //实现批量倒入
    @RequestMapping("/importTrialExcel")
    @ResponseBody
    public String importTrialExcel(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println("文件开始上传");
        int count = excelService.insertTrialExcelData(multipartFile);
        if (count > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}