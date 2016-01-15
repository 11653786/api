package com.yt.activemq.util;

import com.facepp.http.HttpRequests;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class FaceUtil {
    private static final String FACE_API="587b853a637c0e4e59284d253bc290b2";
    private static final String FACE_KEY="V0zzWeIjgIwEBKsREKaB9NESpXUFOYBi";
    //cn服务器使用,http模式开启

    /**
     *  初始化
     * @return
     */
    public static HttpRequests getRequestInit(){
       return  new HttpRequests(FACE_API,FACE_KEY,true, true);
    }

}
