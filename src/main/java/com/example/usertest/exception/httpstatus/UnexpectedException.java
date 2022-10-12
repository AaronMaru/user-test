package com.example.usertest.exception.httpstatus;

public class UnexpectedException extends RuntimeException {
    private int status;
    private String message;
    private Object data;

    public UnexpectedException(int status, String message, Object data) {
        this.status = status;
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
