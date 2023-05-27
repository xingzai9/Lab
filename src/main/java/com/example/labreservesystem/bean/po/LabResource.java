package com.example.labreservesystem.bean.po;

public class LabResource {
    private Integer lab_id;
    private Integer seat_num;
    private String lab_name;
    private String belong_department;
    private Integer lab_manager_id;
    private Boolean can_use;
    public LabResource(){}
    public LabResource(Integer lab_id, Integer seat_num, String lab_name, String belong_department, Integer lab_manager_id, Boolean can_use) {
        this.lab_id = lab_id;
        this.seat_num = seat_num;
        this.lab_name = lab_name;
        this.belong_department = belong_department;
        this.lab_manager_id = lab_manager_id;
        this.can_use = can_use;
    }

    public Integer getLab_id() {
        return lab_id;
    }

    public void setLab_id(Integer lab_id) {
        this.lab_id = lab_id;
    }

    public Integer getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(Integer seat_num) {
        this.seat_num = seat_num;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public String getBelong_department() {
        return belong_department;
    }

    public void setBelong_department(String belong_department) {
        this.belong_department = belong_department;
    }

    public Integer getLab_manager_id() {
        return lab_manager_id;
    }

    public void setLab_manager_id(Integer lab_manager_id) {
        this.lab_manager_id = lab_manager_id;
    }

    public Boolean getCan_use() {
        return can_use;
    }

    public void setCan_use(Boolean can_use) {
        this.can_use = can_use;
    }

    @Override
    public String toString() {
        return "LabResource{" +
                "lab_id=" + lab_id +
                ", seat_num=" + seat_num +
                ", lab_name='" + lab_name + '\'' +
                ", belong_department='" + belong_department + '\'' +
                ", lab_manager_id=" + lab_manager_id +
                ", can_use=" + can_use +
                '}';
    }
}
