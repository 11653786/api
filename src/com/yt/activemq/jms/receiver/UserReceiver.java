package com.yt.activemq.jms.receiver;

import com.yt.activemq.entity.User;

/**
 * Created by Administrator on 2016/1/13 0013.
 */

public class UserReceiver{

    public static void receiver(Object object){
        User user= (User) object;
        System.out.println("用户名: "+user.getName());
    }
}
