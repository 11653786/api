package com.yt.activemq.entity.face;

/**
 * 相应人脸的左。右侧嘴角坐标，x & y 坐标分别表示在图片中的宽度和高度的百分比
 * Created by Administrator on 2016/1/15 0015.
 */
public class Mouth {
    private String y;
    private String x;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
