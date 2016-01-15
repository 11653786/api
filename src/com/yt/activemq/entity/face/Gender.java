package com.yt.activemq.entity.face;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class Gender {

    private String value;
    private double confidence;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
