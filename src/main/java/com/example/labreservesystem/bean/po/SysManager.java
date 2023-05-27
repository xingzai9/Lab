package com.example.labreservesystem.bean.po;

public class SysManager {
    private int manager_id;
    private String manager_password;

    public SysManager(int manager_id, String manager_password) {
        this.manager_id = manager_id;
        this.manager_password = manager_password;
    }

    public int getManager_id() {
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
        return "Sysmanager{" +
                "manager_id=" + manager_id +
                ", manager_password='" + manager_password + '\'' +
                '}';
    }
}
