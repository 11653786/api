package com.yt.activemq.entity.face;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class Face {

    private MonthPosition position;
    private String tag;
    private String face_id;
    private Attribute attribute;

    public MonthPosition getPosition() {
        return position;
    }

    public void setPosition(MonthPosition position) {
        this.position = position;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}

