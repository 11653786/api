package com.yt.activemq.controller;

import com.facepp.error.FaceppParseException;
import com.facepp.http.PostParameters;
import com.yt.activemq.entity.face.AllFack;
import com.yt.activemq.model.ResultObject;
import com.yt.activemq.service.face.FaceService;
import com.yt.activemq.util.FaceUtil;
import com.yt.activemq.util.GsonUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Administrator on 2016/1/8 0008.
 */
@RequestMapping(value = "/face")
@Controller
public class TestController {

    @Autowired
    private FaceService faceService;


    /**
     * 选择图片
     * @return
     */
    @RequestMapping(value = "/allface",method = RequestMethod.GET)
    public String face(){
        return "face";
    }

    /**
     * 获取全部信息
     * @return
     */
    @RequestMapping(value = "/allface",method = RequestMethod.POST)
    @ResponseBody
    public ResultObject allFace(String url){
        return faceService.getAllFace(url);
    }


    @RequestMapping(value = "/landmark",method = RequestMethod.GET)
    @ResponseBody
    public  ResultObject landmark(String faceId) throws FaceppParseException {
        JSONObject jsonObject= FaceUtil.getRequestInit().detectionLandmark(new PostParameters().setFaceId(faceId));
        ResultObject resultObject=new ResultObject(true);
        resultObject.setMessage("鉴定成功");
        return resultObject;
    }



    /**
     * 这个方法没用的
     * @param files
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @Deprecated
    public String addUser(@RequestParam("file") MultipartFile[] files,HttpServletRequest request){
        MultipartFile file=files[0];
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                System.out.println("上传文件："+e.getMessage());
                e.printStackTrace();
            }
        }
        return "/success";
    }



}
