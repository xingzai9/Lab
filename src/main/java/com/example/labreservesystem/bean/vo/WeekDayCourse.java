package com.example.labreservesystem.bean.vo;

public class WeekDayCourse {
    private Integer number;
    private String Week;
    private String day;
    private String course;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
        Week = week;
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

    public WeekDayCourse(Integer number, String week, String day, String course) {
        this.number = number;
        Week = week;
        this.day = day;
        this.course = course;
    }

    @Override
    public String toString() {
        return "WeekDayCourse{" +
                "number=" + number +
                ", Week='" + Week + '\'' +
                ", day='" + day + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
