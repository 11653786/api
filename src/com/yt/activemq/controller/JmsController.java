package com.yt.activemq.controller;

import com.yt.activemq.enmu.MsgType;
import com.yt.activemq.entity.User;
import com.yt.activemq.jms.send.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/19 0019.
 */
@RestController
@RequestMapping(value = "/jms")
public class JmsController {

    @Autowired
    private JmsSender jmsSender;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void TestController() {
        Random random = new Random();
        User user = new User();
        user.setName("name" + random.nextInt());
        //jmsSender.sendMessage("hello,world",null, MsgType.TextMessage.getMessageType());
        jmsSender.sendMessage("hello,world", user, MsgType.ObjMessage.getMessageType());
    }
}
