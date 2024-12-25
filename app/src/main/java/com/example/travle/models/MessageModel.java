package com.example.travle.models;

public class MessageModel {
    private String name;
    private String status;
    private String time;

    public MessageModel(String name, String status, String time) {
        this.name = name;
        this.status = status;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }
}
