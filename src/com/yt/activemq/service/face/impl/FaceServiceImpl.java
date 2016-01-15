package com.yt.activemq.service.face.impl;

import com.facepp.error.FaceppParseException;
import com.facepp.http.PostParameters;
import com.yt.activemq.entity.face.AllFack;
import com.yt.activemq.model.ResultObject;
import com.yt.activemq.service.face.FaceService;
import com.yt.activemq.util.FaceUtil;
import com.yt.activemq.util.GsonUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
@Service
public class FaceServiceImpl implements FaceService {
    @Override
    public ResultObject getAllFace(String imgUrl) {
        JSONObject jsonObject= null;
        ResultObject resultObject=new ResultObject(false);

        try {
            jsonObject= FaceUtil.getRequestInit().detectionDetect(new PostParameters().setUrl(imgUrl));
            AllFack allFack=  GsonUtil.fromJson(jsonObject.toString(), AllFack.class);

            //https://www.baidu.com/img/bd_logo1.png百度头像
            if(allFack.getFace().size()>1){
                resultObject.setMessage("请传入单人照片!");
                return resultObject;
            }

            if(StringUtils.isEmpty(allFack.getFace()) || allFack.getFace().size()==0) {
                resultObject.setMessage("请传入头像!");
                return resultObject;
            }

            resultObject.setSuccess(true);
            resultObject.setMessage("上传头像成功!");
            resultObject.setObject(allFack);

        } catch (FaceppParseException e) {
            resultObject.setMessage(e.getMessage());
            System.out.println("方法getAllFace调用接口失败: "+e.getMessage());
        }
        return resultObject;

    }
}
