package com.yt.activemq.jms.listener;

import com.yt.activemq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.Enumeration;


/**
 * mq 启动:http://www.tuicool.com/articles/eYFZBz
 * Created by Administrator on 2016/1/8 0008.
 */
public class JmsReceiverListener implements MessageListener{

    private JmsTemplate jmsTemplate;

    /**
     * 构造函数
     */
    public JmsReceiverListener() {
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void onMessage(Message message) {
        try {
             if (message instanceof TextMessage) {
                 TextMessage textMessage = (TextMessage) message;
                System.out.println("接收内容: " + textMessage.getText());
             }else if(message instanceof  ObjectMessage){
                 ObjectMessage objectMessage= (ObjectMessage) message;
                 System.out.println(objectMessage.getObject());
             }
        } catch (JMSException e) {
            System.out.println("接收异常: "+e.getMessage());
        }
    }
}
