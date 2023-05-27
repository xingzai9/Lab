package com.example.labreservesystem.bean.vo;

import lombok.Data;

@Data
public class Person {
    private int id;
    private String gender;
    private String username;

    public Person(int id, String gender, String username) {
        this.id = id;
        this.gender = gender;
        this.username = username;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
