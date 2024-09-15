package com.example.GroupWork5.exception;

import java.util.List;

public class ExceptionBody {

    private List<String> message;

    private String time;

    // --------------------- Constructors -------------------------
    public ExceptionBody() {
    }

    public ExceptionBody(List<String> message, String time) {
        this.message = message;
        this.time = time;
    }

// ------------------- Setters and Getters --------------------


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
