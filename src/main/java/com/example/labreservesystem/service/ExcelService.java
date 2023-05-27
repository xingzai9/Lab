package com.example.labreservesystem.service;


import com.example.labreservesystem.bean.po.TeaStuSemester;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    public Integer insertStuExcelData(MultipartFile multipartFile);
    public Integer insertTeaExcelData(MultipartFile multipartFile);
    public Integer insertTrialExcelData(MultipartFile multipartFile);
}
