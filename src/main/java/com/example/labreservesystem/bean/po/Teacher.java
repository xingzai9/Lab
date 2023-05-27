package com.example.labreservesystem.bean.po;

public class Teacher {
    private Integer id;
    private String tea_id;
    private String tea_name;
    private String tea_password;
    private boolean tea_gender;
    private String tea_department;
    private String e_mail;

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
    public Teacher(){}
    public Teacher(Integer id, String tea_id, String tea_name, String tea_password, boolean tea_gender, String tea_department, String e_mail) {
        this.id = id;
        this.tea_id = tea_id;
        this.tea_name = tea_name;
        this.tea_password = tea_password;
        this.tea_gender = tea_gender;
        this.tea_department = tea_department;
        this.e_mail = e_mail;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTea_id() {
        return tea_id;
    }

    public void setTea_id(String tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getTea_password() {
        return tea_password;
    }

    public void setTea_password(String tea_password) {
        this.tea_password = tea_password;
    }

    public boolean isTea_gender() {
        return tea_gender;
    }

    public void setTea_gender(boolean tea_gender) {
        this.tea_gender = tea_gender;
    }

    public String getTea_department() {
        return tea_department;
    }

    public void setTea_department(String tea_department) {
        this.tea_department = tea_department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tea_id='" + tea_id + '\'' +
                ", tea_name='" + tea_name + '\'' +
                ", tea_password='" + tea_password + '\'' +
                ", tea_gender=" + tea_gender +
                ", tea_department='" + tea_department + '\'' +
                ", e_mail='" + e_mail + '\'' +
                '}';
    }
}
