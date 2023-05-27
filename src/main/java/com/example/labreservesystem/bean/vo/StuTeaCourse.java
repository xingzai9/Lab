package com.example.labreservesystem.bean.vo;

public class StuTeaCourse {

    private String Stu_num;
    private String Tea_id;
    private String trial_name;

    public StuTeaCourse(String stu_num, String tea_id, String trial_name) {
        Stu_num = stu_num;
        Tea_id = tea_id;
        this.trial_name = trial_name;
    }

    public String getStu_num() {
        return Stu_num;
    }

    public void setStu_num(String stu_num) {
        Stu_num = stu_num;
    }

    public String getTea_id() {
        return Tea_id;
    }

    public void setTea_id(String tea_id) {
        Tea_id = tea_id;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    @Override
    public String toString() {
        return "StuTeaCourse{" +
                "Stu_num='" + Stu_num + '\'' +
                ", Tea_id='" + Tea_id + '\'' +
                ", trial_name='" + trial_name + '\'' +
                '}';
    }
}
