package com.example.labreservesystem.mapper;

import com.example.labreservesystem.bean.po.Student;
import com.example.labreservesystem.bean.po.TeaStuSemester;
import com.example.labreservesystem.bean.po.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelMapper {
    public Integer insertStuExcelData(List<Student> students);
    public Integer insertTeaExcelData(List<Teacher> teachers);
    public Integer insertTrialExcelData(List<TeaStuSemester> teaStuSemesterList);
}
