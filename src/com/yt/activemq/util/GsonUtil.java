package com.yt.activemq.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class GsonUtil {
   private static final  Gson gson=new Gson();

    /**
     * json字符串转成对象,用于list
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
}
