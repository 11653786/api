package com.yt.activemq.entity.face;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class MonthPosition {

    private Mouth month_right;
    private Mouth mouth_left;
    private Mouth center;
    private String height;
    private String width;
    private Mouth nose;
    private Mouth eye_left;
    private Mouth eye_right;


    public Mouth getMonth_right() {
        return month_right;
    }

    public void setMonth_right(Mouth month_right) {
        this.month_right = month_right;
    }

    public Mouth getMouth_left() {
        return mouth_left;
    }

    public void setMouth_left(Mouth mouth_left) {
        this.mouth_left = mouth_left;
    }

    public Mouth getCenter() {
        return center;
    }

    public void setCenter(Mouth center) {
        this.center = center;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Mouth getNose() {
        return nose;
    }

    public void setNose(Mouth nose) {
        this.nose = nose;
    }

    public Mouth getEye_left() {
        return eye_left;
    }

    public void setEye_left(Mouth eye_left) {
        this.eye_left = eye_left;
    }

    public Mouth getEye_right() {
        return eye_right;
    }

    public void setEye_right(Mouth eye_right) {
        this.eye_right = eye_right;
    }
}
