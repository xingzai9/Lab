package com.example.labreservesystem.bean.po;

public class ReserveByStu {
    private Integer id;
    private String stu_num;
    private String tea_id;
    private String week;
    private String day;
    private String course;
    private String department;
    private String trial_name;
    private String laboratory;

    public ReserveByStu(Integer id, String stu_num, String tea_id, String week, String day, String course, String department, String trial_name, String laboratory) {
        this.id = id;
        this.stu_num = stu_num;
        this.tea_id = tea_id;
        this.week = week;
        this.day = day;
        this.course = course;
        this.department = department;
        this.trial_name = trial_name;
        this.laboratory = laboratory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    @Override
    public String toString() {
        return "ReserveByStu{" +
                "id=" + id +
                ", stu_num='" + stu_num + '\'' +
                ", tea_id='" + tea_id + '\'' +
                ", week='" + week + '\'' +
                ", day='" + day + '\'' +
                ", course='" + course + '\'' +
                ", department='" + department + '\'' +
                ", trial_name='" + trial_name + '\'' +
                ", laboratory='" + laboratory + '\'' +
                '}';
    }
}
