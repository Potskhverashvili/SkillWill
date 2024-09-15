package com.example.Assignment_25.exception;

import java.util.List;

public class ExceptionBody {

    private List<String> message;

    private Long timeStamp;

    public ExceptionBody() {
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}

