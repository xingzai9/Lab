package com.example.labreservesystem.service;

import com.example.labreservesystem.bean.po.*;
import com.example.labreservesystem.bean.vo.PageUtils;
import com.example.labreservesystem.bean.vo.StuTeaCourse;
import com.example.labreservesystem.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAllTeacher(Map map) {
        return teacherMapper.getAllTeacher(map);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(String tea_id) {
        return teacherMapper.getTeacherById(tea_id);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) {
        return teacherMapper.deleteTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }
    @Override
    public int getTeacherCount(){
        return teacherMapper.getTeacherCount();
    }

    @Override
    public List<ReserveByTea> getReserveByTea(StuAndTea stuAndTea) {
        return teacherMapper.getReserveByTea(stuAndTea);
    }

    @Override
    public List<ReserveByTea> getAllReserveByTea() {
        return teacherMapper.getAllReserveByTea();
    }

    @Override
    public List<ReserveEnsure> getReserveRecordById(PageUtils pageUtils) {
        return teacherMapper.getReserveRecordById(pageUtils);
    }

    @Override
    public Boolean deleteReserveRecordById(String ensure_id) {
        return teacherMapper.deleteReserveRecordById(ensure_id);
    }

    @Override
    public List<Student> getMyStudent(PageUtils pageUtils) {
        return teacherMapper.getMyStudent(pageUtils);
    }

    @Override
    public Boolean deleteMyStudent(StuTeaCourse stuTeaCourse) {
        return teacherMapper.deleteMyStudent(stuTeaCourse);
    }

    @Override
    public List<TeaStuSemester> getMyTrial(PageUtils pageUtils) {
        List<TeaStuSemester> teaStuSemesterList =  teacherMapper.getMyTrial(pageUtils);
//        for(TeaStuSemester t:teaStuSemesterList){
//            t.setId(1);
//        }
        List<TeaStuSemester> teaStuSemesters = new ArrayList<>();
        for(TeaStuSemester t:teaStuSemesterList){
            if(!teaStuSemesters.contains(t)){
                teaStuSemesters.add(t);
            }
        }
        return teaStuSemesters;
    }

    @Override
    public Boolean deleteMyTrial(TeaStuSemester teaStuSemester)  {
        return teacherMapper.deleteMyTrial(teaStuSemester);
    }

    @Override
    public Boolean deleteMyReservePlan(ReserveByTea reserveByTea) {
        return teacherMapper.deleteMyReservePlan(reserveByTea);
    }

    @Override
    public Boolean addReservePlan(ReservePlan reservePlan) {
        return teacherMapper.addReservePlan(reservePlan);
    }

    @Override
    public List<ReserveByTea> getReserveByTeaById(PageUtils pageUtils) {
        return teacherMapper.getReserveByTeaById(pageUtils);
    }

    @Override
    public Boolean deleteReserveByTeaById(String reserveByTea_id) {
        return teacherMapper.deleteReserveByTeaById(reserveByTea_id);
    }

    @Override
    public Integer getReserveByTeaByIdCount(PageUtils pageUtils) {
        return teacherMapper.getReserveByTeaByIdCount(pageUtils);
    }

    @Override
    public List<Message> getMyMessage(PageUtils pageUtils) {
        return teacherMapper.getMyMessage(pageUtils);
    }

    @Override
    public Integer getMyMessageCount(String tea_id) {
        return teacherMapper.getMyMessageCount(tea_id);
    }

    @Override
    public Boolean changeIsRead(String tea_id) {
        return teacherMapper.changeIsRead(tea_id);
    }

    @Override
    public Boolean deleteMessage(Integer message_id) {
        return teacherMapper.deleteMessage(message_id);
    }

    @Override
    public Integer getMyStudentCount(String tea_id) {
        return teacherMapper.getMyStudentCount(tea_id);
    }

    @Override
    public Integer getMyTrialCount(String tea_id) {
        return teacherMapper.getMyTrialCount(tea_id);
    }

    @Override
    public List<String> getTrialNameList(String tea_id) {
        return teacherMapper.getTrialNameList(tea_id);
    }

    @Override
    public Integer getReserveRecordByIdCount(String tea_id) {
        return teacherMapper.getReserveRecordByIdCount(tea_id);
    }

    @Override
    public List<LabResource> getRecommendLaboratory(ReserveEnsure reserveEnsure) {
        return teacherMapper.getRecommendLaboratory(reserveEnsure);
    }

    @Override
    public List<String> getAllTrial(String tea_id) {
        return teacherMapper.getAllTrial(tea_id);
    }

    @Override
    public List<ReserveEnsure> getHoldCourse(ReserveEnsure reserveEnsure) {
        return teacherMapper.getHoldCourse(reserveEnsure);
    }

    @Override
    public boolean deleteTeacherById(String tea_id) {
        return teacherMapper.deleteTeacherById(tea_id);
    }
}
