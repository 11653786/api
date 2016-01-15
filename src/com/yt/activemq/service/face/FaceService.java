package com.yt.activemq.service.face;

import com.facepp.error.FaceppParseException;
import com.yt.activemq.model.ResultObject;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public interface FaceService {

    /**
     * 获取一张图片中全部的人脸
     * @return
     */
    public ResultObject getAllFace(String imgUrl);
}
