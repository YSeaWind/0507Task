package com.example.a0507task.utils;

public class Message {
    public String getMessagename() {
        return messagename;
    }

    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }

    private String messagename;

    public Message(String messagename) {
        this.messagename = messagename;
    }
}
