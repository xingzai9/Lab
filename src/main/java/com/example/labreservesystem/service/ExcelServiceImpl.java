package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.Student;
import com.example.labreservesystem.bean.po.TeaStuSemester;
import com.example.labreservesystem.bean.po.Teacher;
import com.example.labreservesystem.mapper.ExcelMapper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService{
    @Autowired
    ExcelMapper excelMapper;
    @Override
    public Integer insertStuExcelData(MultipartFile multipartFile) {
        //创建一个List集合，用来存放数据
        List<Student> stuList = new ArrayList<>();
        try {
            //获得文件输入流
            XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
            //获得Excel表的sheet的数目
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //变量Excel表中的sheet
                XSSFSheet sheet = sheets.getSheetAt(i);
                //获得sheet中的行数
                for (int j = 1; j < sheet.getLastRowNum() +1; j++) {
                    //创建对象
                    Student student = new Student();
                    //遍历每行有效的单元格数目
                    for (int k = 0; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {
                        DataFormatter dataFormatter = new DataFormatter();
                        //获得单元格的数据
                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));
                        //将获得的数据设置到student对象属性中
                        switch (k) {
                            case 0:
                                student.setId(Integer.parseInt(stringCellValue));
                                break;
                            case 1:
                                student.setStu_num(stringCellValue);
                                break;
                            case 2:
                                student.setStu_password(stringCellValue);
                                break;
                            case 3:
                                student.setStu_gender(Boolean.parseBoolean(stringCellValue));
                                break;
                            case 4:
                                student.setStu_name(stringCellValue);
                                break;
                            case 5:
                                student.setStu_class(stringCellValue);
                                break;
                            case 6:
                                student.setStu_department(stringCellValue);
                                break;
                            case 7:
                                student.setE_mail(stringCellValue);
                                System.out.println("excel"+student);
                                break;
                        }
                    }
                    //将对向添加到List集合中
                    stuList.add(student);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("上传到数据库完毕");
        return excelMapper.insertStuExcelData(stuList);
    }

    @Override
    public Integer insertTeaExcelData(MultipartFile multipartFile) {
        //创建一个List集合，用来存放数据
        List<Teacher> teaList = new ArrayList<>();
        try {
            //获得文件输入流
            XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
            //获得Excel表的sheet的数目
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //变量Excel表中的sheet
                XSSFSheet sheet = sheets.getSheetAt(i);
                //获得sheet中的行数
                for (int j = 1; j < sheet.getLastRowNum() +1; j++) {
                    //创建对象
                    Teacher teacher = new Teacher();
                    //遍历每行有效的单元格数目
                    for (int k = 0; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {
                        DataFormatter dataFormatter = new DataFormatter();
                        //获得单元格的数据
                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));
                        //将获得的数据设置到student对象属性中
                        switch (k) {
                            case 0:
                                teacher.setId(Integer.parseInt(stringCellValue));
                                break;
                            case 1:
                                teacher.setTea_id(stringCellValue);
                                break;
                            case 2:
                                teacher.setTea_name(stringCellValue);
                                break;
                            case 3:
                                teacher.setTea_password(stringCellValue);
                                break;
                            case 4:
                                teacher.setTea_gender(Boolean.parseBoolean(stringCellValue));
                                break;
                            case 5:
                                teacher.setTea_department(stringCellValue);
                                break;
                            case 6:
                                teacher.setE_mail(stringCellValue);
                                break;
                        }
                    }
                    //将对向添加到List集合中
                    teaList.add(teacher);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("上传到数据库完毕");
        return excelMapper.insertTeaExcelData(teaList);
    }

    @Override
    public Integer insertTrialExcelData(MultipartFile multipartFile) {
        //创建一个List集合，用来存放数据
        List<TeaStuSemester> teaStuSemesterList = new ArrayList<>();
        try {
            //获得文件输入流
            XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
            //获得Excel表的sheet的数目
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //变量Excel表中的sheet
                XSSFSheet sheet = sheets.getSheetAt(i);
                //获得sheet中的行数
                for (int j = 1; j < sheet.getLastRowNum() +1; j++) {
                    //创建对象
                    TeaStuSemester teaStuSemester = new TeaStuSemester();
                    //遍历每行有效的单元格数目
                    for (int k = 0; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {
                        DataFormatter dataFormatter = new DataFormatter();
                        //获得单元格的数据
                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));
                        //将获得的数据设置到student对象属性中
                        switch (k) {
                            case 0:
                                teaStuSemester.setId(Integer.parseInt(stringCellValue));
                                break;
                            case 1:
                                teaStuSemester.setStu_num(stringCellValue);
                                break;
                            case 2:
                                teaStuSemester.setTea_id(stringCellValue);
                                break;
                            case 3:
                                teaStuSemester.setSemester(stringCellValue);
                                break;
                            case 4:
                                teaStuSemester.setTrial_name(stringCellValue);
                                break;
                        }
                    }
                    //将对向添加到List集合中
                    teaStuSemesterList.add(teaStuSemester);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("上传到数据库完毕");
        return excelMapper.insertTrialExcelData(teaStuSemesterList);
    }

}
