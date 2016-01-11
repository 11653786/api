package com.yt.activemq.junit.test;

import com.yt.activemq.enmu.MsgType;
import com.yt.activemq.entity.User;
import com.yt.activemq.jms.send.JmsSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/8 0008.
 */
public class SenderTest {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        JmsSender jmsSender=context.getBean(JmsSender.class);
        Random random=new Random();
        //jmsSender.sendMessage("hello,world",null, MsgType.TextMessage.getMessageType());
        jmsSender.sendMessage("hello,world",new User("name"+random.nextInt()),MsgType.ObjMessage.getMessageType());
    }
}
