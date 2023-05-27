package com.example.labreservesystem.bean.po;

public class LabManager {
    private Integer manager_id;
    private String manager_password;
    private String e_mail;

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public LabManager(Integer manager_id, String manager_password, String e_mail) {
        this.manager_id = manager_id;
        this.manager_password = manager_password;
        this.e_mail = e_mail;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    @Override
    public String toString() {
        return "labmanager{" +
                "manager_id=" + manager_id +
                ", manager_password='" + manager_password + '\'' +
                '}';
    }
}
