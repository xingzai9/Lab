package com.example.labreservesystem.bean.po;

import java.sql.Timestamp;

public class Message {
    private Integer id;
    private String reason;
    private String text;
    private String to_teacher_id;
    private String manager_id;
    private String trial_name;
    private Boolean isRead;

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Timestamp getSend_time() {
        return send_time;
    }

    public void setSend_time(Timestamp send_time) {
        this.send_time = send_time;
    }

    private Timestamp send_time;
    public Message(Integer id, String reason, String text, String to_teacher_id, String manager_id, String trial_name, Boolean isRead, Timestamp send_time) {
        this.id = id;
        this.reason = reason;
        this.text = text;
        this.to_teacher_id = to_teacher_id;
        this.manager_id = manager_id;
        this.trial_name = trial_name;
        this.isRead = isRead;
        this.send_time = send_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo_teacher_id() {
        return to_teacher_id;
    }

    public void setTo_teacher_id(String to_teacher_id) {
        this.to_teacher_id = to_teacher_id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getTrial_name() {
        return trial_name;
    }

    public void setTrial_name(String trial_name) {
        this.trial_name = trial_name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", text='" + text + '\'' +
                ", to_teacher_id='" + to_teacher_id + '\'' +
                ", manager_id='" + manager_id + '\'' +
                ", trial_name='" + trial_name + '\'' +
                '}';
    }
}
