package com.yt.activemq.model;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class ResultObject {

    private String message;
    private Object object;
    private boolean success;

    public ResultObject(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
