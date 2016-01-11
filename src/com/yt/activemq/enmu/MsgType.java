package com.yt.activemq.enmu;

/**
 * Created by Administrator on 2016/1/11 0011.
 */
public enum MsgType{
    TextMessage("text"), ObjMessage("obj"), MapMessage("map"), ListMessage("list");
    public String messageType;

    MsgType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
