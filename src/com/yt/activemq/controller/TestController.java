package com.yt.activemq.controller;

import com.google.gson.Gson;
import com.yt.activemq.entity.User;
import com.yt.activemq.entity.face.AllFack;
import com.yt.activemq.entity.face.Face;
import com.yt.activemq.jms.send.JmsSender;
import com.yt.activemq.service.face.FaceService;
import com.yt.activemq.util.GsonUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by Administrator on 2016/1/8 0008.
 */
@RequestMapping(value = "/face")
@Controller
public class TestController {

    @Autowired
    private FaceService faceService;


    @RequestMapping(value = "/allface")
    @ResponseBody
    public AllFack allFace(){
      JSONObject jsonObject=faceService.getAllFace("http://www.faceplusplus.com.cn/wp-content/themes/faceplusplus/assets/img/demo/9.jpg");
        return  GsonUtil.fromJson(jsonObject.toString(), AllFack.class);
    }




}
