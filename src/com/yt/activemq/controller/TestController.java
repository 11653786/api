package com.yt.activemq.controller;

import com.yt.activemq.jms.send.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/8 0008.
 */
@RequestMapping(value = "/test")
@Controller
public class TestController {

    @Autowired
    JmsSender jmsSender;


    @RequestMapping(value = "/test")
    public String test(){
        Random random=new Random();
        jmsSender.sendMessage("name"+random.nextInt());
        return "test";
    }


}
