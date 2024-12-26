package com.example.travle.models;

public class MessageModel {
    private String name;
    private String status;
    private String time;
    public int img;

    public MessageModel(int img,String name, String status, String time) {
        this.name = name;
        this.status = status;
        this.time = time;
        this.img=img;
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
