package com.example.labreservesystem.bean.po;

public class Student {
    private Integer id;
    private String stu_num;
    private String stu_password;
    private boolean stu_gender;
    private String stu_name;
    private String stu_class;
    private String stu_department;
    private String e_mail;
    public Student(){}
    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_department() {
        return stu_department;
    }

    public void setStu_department(String stu_department) {
        this.stu_department = stu_department;
    }

    public Student(Integer id, String stu_num, String stu_password, boolean stu_gender, String stu_name, String stu_class, String stu_department, String e_mail) {
        this.id = id;
        this.stu_num = stu_num;
        this.stu_password = stu_password;
        this.stu_gender = stu_gender;
        this.stu_name = stu_name;
        this.stu_class = stu_class;
        this.stu_department = stu_department;
        this.e_mail = e_mail;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
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

    public String getStu_password() {
        return stu_password;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }

    public boolean isStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(boolean stu_gender) {
        this.stu_gender = stu_gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stu_num='" + stu_num + '\'' +
                ", stu_password='" + stu_password + '\'' +
                ", stu_gender=" + stu_gender +
                ", stu_name='" + stu_name + '\'' +
                ", stu_class='" + stu_class + '\'' +
                ", stu_department='" + stu_department + '\'' +
                ", e_mail='" + e_mail + '\'' +
                '}';
    }
}
