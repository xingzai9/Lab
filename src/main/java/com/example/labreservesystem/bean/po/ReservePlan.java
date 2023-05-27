package com.example.labreservesystem.bean.po;

public class ReservePlan {
    private Integer plan_id;
    private String reserve_day;
    private String reserve_week;
    private String reserve_course;
    private Integer trial_num;
    private String trial_name;
    private String trial_id;
    private Boolean is_refused;
    private String class_time;
    private String reserve_tea_id;
    private String laboratory;
    private String department;

    public ReservePlan(Integer plan_id, String reserve_day, String reserve_week, String reserve_course, Integer trial_num, String trial_name, String trial_id, Boolean is_refused, String class_time, String reserve_tea_id, String laboratory, String department) {
        this.plan_id = plan_id;
        this.reserve_day = reserve_day;
        this.reserve_week = reserve_week;
        this.reserve_course = reserve_course;
        this.trial_num = trial_num;
        this.trial_name = trial_name;
        this.trial_id = trial_id;
        this.is_refused = is_refused;
        this.class_time = class_time;
        this.reserve_tea_id = reserve_tea_id;
        this.laboratory = laboratory;
        this.department = department;
    }

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public String getReserve_day() {
        return reserve_day;
    }

    public void setReserve_day(String reserve_day) {
        this.reserve_day = reserve_day;
    }

    public String getReserve_week() {
        return reserve_week;
    }

    public void setReserve_week(String reserve_week) {
        this.reserve_week = reserve_week;
    }

    public String getReserve_course() {
        return reserve_course;
    }

    public void setReserve_course(String reserve_course) {
        this.reserve_course = reserve_course;
    }

    public Integer getTrial_num() {
        return trial_num;
    }

    public void setTrial_num(Integer trial_num) {
        this.trial_num = trial_num;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    public String getTrial_id() {
        return trial_id;
    }

    public void setTrial_id(String trial_id) {
        this.trial_id = trial_id;
    }

    public Boolean getIs_refused() {
        return is_refused;
    }

    public void setIs_refused(Boolean is_refused) {
        this.is_refused = is_refused;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getReserve_tea_id() {
        return reserve_tea_id;
    }

    public void setReserve_tea_id(String reserve_tea_id) {
        this.reserve_tea_id = reserve_tea_id;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ReservePlan{" +
                "plan_id=" + plan_id +
                ", reserve_day=" + reserve_day +
                ", reserve_week='" + reserve_week + '\'' +
                ", reserve_course='" + reserve_course + '\'' +
                ", trial_num=" + trial_num +
                ", trial_name='" + trial_name + '\'' +
                ", trial_id='" + trial_id + '\'' +
                ", is_refused=" + is_refused +
                ", class_time=" + class_time +
                ", reserve_tea_id='" + reserve_tea_id + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
