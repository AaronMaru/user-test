package com.example.usertest.exception.httpstatus;

public class BadRequestException extends RuntimeException {
    private String message;
    private Object data;

    public BadRequestException(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
