package com.yt.activemq.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/8 0008.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2620024932905963095L;


    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
