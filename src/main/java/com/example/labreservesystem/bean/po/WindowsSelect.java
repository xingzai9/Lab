package com.example.labreservesystem.bean.po;

import java.util.Date;

public class WindowsSelect {
    private int win_id;
    private Date win_day;
    private int course_order;
    private int lab_id;
    private String lab_name;

    public WindowsSelect(int win_id, Date win_day, int course_order, int lab_id, String lab_name) {
        this.win_id = win_id;
        this.win_day = win_day;
        this.course_order = course_order;
        this.lab_id = lab_id;
        this.lab_name = lab_name;
    }

    public int getWin_id() {
        return win_id;
    }

    public void setWin_id(int win_id) {
        this.win_id = win_id;
    }

    public Date getWin_day() {
        return win_day;
    }

    public void setWin_day(Date win_day) {
        this.win_day = win_day;
    }

    public int getCourse_order() {
        return course_order;
    }

    public void setCourse_order(int course_order) {
        this.course_order = course_order;
    }

    public int getLab_id() {
        return lab_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    @Override
    public String toString() {
        return "WindowsSelect{" +
                "win_id=" + win_id +
                ", win_day=" + win_day +
                ", course_order=" + course_order +
                ", lab_id=" + lab_id +
                ", lab_name='" + lab_name + '\'' +
                '}';
    }
}
