package com.yt.activemq.jms.listener;

import com.yt.activemq.entity.User;
import com.yt.activemq.jms.converter.ObjectMessageConverter;
import com.yt.activemq.jms.receiver.UserReceiver;
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
    @Autowired
    private ObjectMessageConverter converter;

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
             if(message instanceof  ObjectMessage){
                Object object=converter.fromMessage(message);
                 //监听器里面什么才做都不做放到外面的处理类,可以根据类上的注解来扫描的
                 if(object.getClass().getSimpleName().equalsIgnoreCase("user")){
                     UserReceiver.receiver(object);
                 }
             }
        } catch (JMSException e) {
            System.out.println("接收异常: "+e.getMessage());
        }
    }
}
