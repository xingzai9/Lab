package com.example.labreservesystem.bean.po;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Timestamp;
import java.util.Date;

public class ReserveEnsure {
    private Integer ensure_id;
    private String week;
    private String day;
    private String course;
    private String laboratory;
    private Integer trial_num;
    private String trial_id;
    private String trial_name;
    private String reserve_tea_id;
    private String department;
    private Timestamp operate_time;
    public ReserveEnsure(){}
    public ReserveEnsure(Integer ensure_id, String week, String day, String course, String laboratory, Integer trial_num, String trial_id, String trial_name, String reserve_tea_id, String department, Timestamp operate_time) {
        this.ensure_id = ensure_id;
        this.week = week;
        this.day = day;
        this.course = course;
        this.laboratory = laboratory;
        this.trial_num = trial_num;
        this.trial_id = trial_id;
        this.trial_name = trial_name;
        this.reserve_tea_id = reserve_tea_id;
        this.department = department;
        this.operate_time = operate_time;
    }

    public Integer getEnsure_id() {
        return ensure_id;
    }

    public void setEnsure_id(Integer ensure_id) {
        this.ensure_id = ensure_id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public Integer getTrial_num() {
        return trial_num;
    }

    public void setTrial_num(Integer trial_num) {
        this.trial_num = trial_num;
    }

    public String getTrial_id() {
        return trial_id;
    }

    public void setTrial_id(String trial_id) {
        this.trial_id = trial_id;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    public String getReserve_tea_id() {
        return reserve_tea_id;
    }

    public void setReserve_tea_id(String reserve_tea_id) {
        this.reserve_tea_id = reserve_tea_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Timestamp getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(Timestamp operate_time) {
        this.operate_time = operate_time;
    }

    @Override
    public String toString() {
        return "ReserveEnsure{" +
                "ensure_id=" + ensure_id +
                ", week='" + week + '\'' +
                ", day='" + day + '\'' +
                ", course='" + course + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", trial_num=" + trial_num +
                ", trial_id='" + trial_id + '\'' +
                ", trial_name='" + trial_name + '\'' +
                ", reserve_tea_id='" + reserve_tea_id + '\'' +
                ", department='" + department + '\'' +
                ", operate_time=" + operate_time +
                '}';
    }
}

