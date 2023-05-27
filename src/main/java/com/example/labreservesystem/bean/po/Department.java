package com.example.labreservesystem.bean.po;


public class Department {
    private Integer id;
    private String dept_name;
    private Integer dept_stu_num;
    private Integer dept_tea_num;

    public Department(Integer id, String dept_name, Integer dept_stu_num, Integer dept_tea_num) {
        this.id = id;
        this.dept_name = dept_name;
        this.dept_stu_num = dept_stu_num;
        this.dept_tea_num = dept_tea_num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Integer getDept_stu_num() {
        return dept_stu_num;
    }

    public void setDept_stu_num(Integer dept_stu_num) {
        this.dept_stu_num = dept_stu_num;
    }

    public Integer getDept_tea_num() {
        return dept_tea_num;
    }

    public void setDept_tea_num(Integer dept_tea_num) {
        this.dept_tea_num = dept_tea_num;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                ", dept_stu_num=" + dept_stu_num +
                ", dept_tea_num=" + dept_tea_num +
                '}';
    }
}
