package com.yt.activemq.jms.send;

import com.sun.media.jfxmedia.logging.Logger;
import com.yt.activemq.enmu.MsgType;
import com.yt.activemq.entity.User;
import com.yt.activemq.jms.converter.ObjectMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.StringUtils;

import javax.jms.*;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by Administrator on 2016/1/8 0008.
 */

public class JmsSender {

    private JmsTemplate jmsTemplate;
    private Destination destination;
    @Autowired
    private  ObjectMessageConverter converter;

   private  Random random=new Random();

    public void sendMessage(final String msg,final Serializable entity,final String msgType) {
        if (destination == null) {
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message message = null;
                try {
                   if(msgType.equals(MsgType.TextMessage.getMessageType())){
                     TextMessage  textMessage=session.createTextMessage();
                       textMessage.setText(msg);
                        message=textMessage;
                    }else if(msgType.equals(MsgType.ObjMessage.getMessageType())){
                       message=converter.toMessage(entity,session);
                   }else if(msgType.equals(MsgType.MapMessage.getMessageType())){
                       MapMessage mapMessage=session.createMapMessage();
                       mapMessage.setObject("KEY2","VALUE");
                       message=mapMessage;
                   }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }finally {

                }
                return message;
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
