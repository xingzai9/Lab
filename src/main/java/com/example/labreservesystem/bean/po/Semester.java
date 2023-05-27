package com.example.labreservesystem.bean.po;

import java.sql.Date;
import java.sql.Timestamp;

public class Semester {
    private Integer semester_id;
    private String semester_name;
    private Date start_date;
    private int start_weekday;
    private int week_num;

    public Semester(Integer semester_id, String semester_name,Date start_date, int start_weekday, int week_num) {
        this.semester_id = semester_id;
        this.semester_name = semester_name;
        this.start_date = start_date;
        this.start_weekday = start_weekday;
        this.week_num = week_num;
    }

    public Integer getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(Integer semester_id) {
        this.semester_id = semester_id;
    }

    public String getSemester_name() {
        return semester_name;
    }

    public void setSemester_name(String semester_name) {
        this.semester_name = semester_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public int getStart_weekday() {
        return start_weekday;
    }

    public void setStart_weekday(int start_weekday) {
        this.start_weekday = start_weekday;
    }

    public int getWeek_num() {
        return week_num;
    }

    public void setWeek_num(int week_num) {
        this.week_num = week_num;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semester_id=" + semester_id +
                ", semester_name='" + semester_name + '\'' +
                ", start_date=" + start_date +
                ", start_weekday='" + start_weekday + '\'' +
                ", week_num=" + week_num +
                '}';
    }
}
