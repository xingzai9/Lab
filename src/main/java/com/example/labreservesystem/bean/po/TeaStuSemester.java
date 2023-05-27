package com.example.labreservesystem.bean.po;

import javax.persistence.criteria.CriteriaBuilder;

public class TeaStuSemester {
    private Integer id;
    private String stu_num;
    private String tea_id;
    private String semester;
    private String trial_name;
    public TeaStuSemester(){}
    public TeaStuSemester(Integer id, String stu_num, String tea_id, String semester, String trial_name) {
        this.id = id;
        this.stu_num = stu_num;
        this.tea_id = tea_id;
        this.semester = semester;
        this.trial_name = trial_name;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    @Override
    public String toString() {
        return "TeaStuSemester{" +
                "id=" + id +
                ", stu_num='" + stu_num + '\'' +
                ", tea_id='" + tea_id + '\'' +
                ", semester='" + semester + '\'' +
                ", trial_name='" + trial_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return true;
        TeaStuSemester teaStuSemester = (TeaStuSemester) obj;
        if(tea_id.equals(teaStuSemester.tea_id)
                && semester.equals(teaStuSemester.semester) &&trial_name.equals(teaStuSemester.trial_name)){
            return true;
        }
        return false;
    }
}
