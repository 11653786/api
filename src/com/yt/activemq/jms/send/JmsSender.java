package com.yt.activemq.jms.send;

import com.yt.activemq.entity.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.StringUtils;

import javax.jms.*;
import java.util.Random;

/**
 * Created by Administrator on 2016/1/8 0008.
 */

public class JmsSender {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public void sendMessage(final String message) {
        if(destination==null){
        destination=jmsTemplate.getDefaultDestination();
        }
        System.out.println("---------------生产者发了一个消息：" + message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }



    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }



}
