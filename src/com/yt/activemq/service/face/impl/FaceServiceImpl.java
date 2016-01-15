package com.yt.activemq.service.face.impl;

import com.facepp.error.FaceppParseException;
import com.facepp.http.PostParameters;
import com.yt.activemq.service.face.FaceService;
import com.yt.activemq.util.FaceUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
@Service
public class FaceServiceImpl implements FaceService {
    @Override
    public JSONObject getAllFace(String imgUrl) {
        JSONObject jsonObject= null;
        try {
            jsonObject= FaceUtil.getRequestInit().detectionDetect(new PostParameters().setUrl(imgUrl));
        } catch (FaceppParseException e) {
            System.out.println("方法getAllFace调用接口失败: "+e.getMessage());
        }
        return jsonObject;
    }
}
