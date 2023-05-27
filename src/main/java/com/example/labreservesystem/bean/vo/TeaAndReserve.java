package com.example.labreservesystem.bean.vo;

public class TeaAndReserve {
    private String tea_id;
    private String tea_name;
    private String e_mail;
    private String trial_name;
    private String department;
    private String laboratory;

    public TeaAndReserve(String tea_id, String tea_name, String e_mail, String trial_name, String department, String laboratory) {
        this.tea_id = tea_id;
        this.tea_name = tea_name;
        this.e_mail = e_mail;
        this.trial_name = trial_name;
        this.department = department;
        this.laboratory = laboratory;
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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
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

    @Override
    public String toString() {
        return "TeaAndReserve{" +
                "tea_id='" + tea_id + '\'' +
                ", tea_name='" + tea_name + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", trial_name='" + trial_name + '\'' +
                ", department='" + department + '\'' +
                ", laboratory='" + laboratory + '\'' +
                '}';
    }
}
