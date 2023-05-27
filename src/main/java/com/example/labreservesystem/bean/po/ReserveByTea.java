package com.example.labreservesystem.bean.po;

import lombok.Data;

@Data
public class ReserveByTea {
    private Integer tea_reserve_record_id;
    private Boolean is_passed;
    private String department;
    private String laboratory;
    private String tea_id;
    private String class_time;
    private String trial_name;
    private Integer trial_num;
    private Integer trial_times;
    private String week;
    private String day;
    private String course;

    public ReserveByTea(){}
    public ReserveByTea(Integer tea_reserve_record_id, Boolean is_passed, String department, String laboratory, String tea_id, String class_time, String trial_name, Integer trial_num, Integer trial_times, String week, String day, String course) {
        this.tea_reserve_record_id = tea_reserve_record_id;
        this.is_passed = is_passed;
        this.department = department;
        this.laboratory = laboratory;
        this.tea_id = tea_id;
        this.class_time = class_time;
        this.trial_name = trial_name;
        this.trial_num = trial_num;
        this.trial_times = trial_times;
        this.week = week;
        this.day = day;
        this.course = course;
    }

    public Integer getTea_reserve_record_id() {
        return tea_reserve_record_id;
    }

    public void setTea_reserve_record_id(Integer tea_reserve_record_id) {
        this.tea_reserve_record_id = tea_reserve_record_id;
    }

    public Boolean getIs_passed() {
        return is_passed;
    }

    public void setIs_passed(Boolean is_passed) {
        this.is_passed = is_passed;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    public Integer getTrial_num() {
        return trial_num;
    }

    public void setTrial_num(Integer trial_num) {
        this.trial_num = trial_num;
    }

    public Integer getTrial_times() {
        return trial_times;
    }

    public void setTrial_times(Integer trial_times) {
        this.trial_times = trial_times;
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

    @Override
    public String toString() {
        return "ReserveByTea{" +
                "tea_reserve_record_id=" + tea_reserve_record_id +
                ", is_passed=" + is_passed +
                ", department='" + department + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", tea_id='" + tea_id + '\'' +
                ", class_time='" + class_time + '\'' +
                ", trial_name='" + trial_name + '\'' +
                ", trial_num=" + trial_num +
                ", trial_times=" + trial_times +
                ", week='" + week + '\'' +
                ", day='" + day + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
