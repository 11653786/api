package com.yt.activemq.controller;

import com.facepp.error.FaceppParseException;
import com.facepp.http.PostParameters;
import com.google.gson.reflect.TypeToken;
import com.yt.activemq.entity.face.AllFack;
import com.yt.activemq.entity.face.Face;
import com.yt.activemq.entity.group.Group;
import com.yt.activemq.entity.person.Person;
import com.yt.activemq.model.ResultObject;
import com.yt.activemq.service.face.FaceService;
import com.yt.activemq.util.FaceUtil;
import com.yt.activemq.util.GsonUtil;
import org.json.JSONException;
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
import java.util.List;
import java.util.PriorityQueue;

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
     *
     * @return
     */
    @RequestMapping(value = "/allface", method = RequestMethod.GET)
    public String face() {
        return "face";
    }

    /**
     * 获取全部信息
     *
     * @return
     */
    @RequestMapping(value = "/allface", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject allFace(String url) {
        return faceService.getAllFace(url);
    }

    //3798516f5bbeada2f1f5806146229667
    @RequestMapping(value = "/landmark", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject landmark(String faceId) throws FaceppParseException {
        JSONObject jsonObject = FaceUtil.getRequestInit().detectionLandmark(new PostParameters().setFaceId(faceId));
        ResultObject resultObject = new ResultObject(true);
        resultObject.setMessage("鉴定成功");
        return resultObject;
    }

    /**
     * 创建组
     *
     * @param groupName 组名
     * @param tag       组描述
     *                  group_id 1dbb717feda214d3c56dff86d0b3acbe
     *                  group_name start
     * @return
     */
    @RequestMapping(value = "/create/group", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject createGroup(@RequestParam(value = "groupName", defaultValue = "组名") String groupName,
                                    @RequestParam(value = "tag", defaultValue = "组描述") String tag) {
        ResultObject resultObject = new ResultObject(true);
        try {
            JSONObject jsonObject = FaceUtil.getRequestInit().groupCreate(new PostParameters().setGroupName(groupName).setTag(tag));
            Group group = GsonUtil.fromJson(jsonObject.toString(), Group.class);
            resultObject.setObject(group);
            resultObject.setMessage("创建组成功!");
        } catch (FaceppParseException e) {
            resultObject.setSuccess(false);
            resultObject.setMessage("创建组失败");
            e.printStackTrace();
        }
        return resultObject;
    }

    //fd681267a13f70bff6b4185d09789613 person_id
    @RequestMapping(value = "/create/person", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject createPerson(@RequestParam(value = "personName", defaultValue = "杨幂") String personName,
                                     @RequestParam(value = "face_id", defaultValue = "3798516f5bbeada2f1f5806146229667") String faceId,
                                     @RequestParam(value = "group_id", defaultValue = "1dbb717feda214d3c56dff86d0b3acbe") String groupId,
                                     @RequestParam(value = "tag", defaultValue = "女明星杨幂头像上传") String tag) {
        ResultObject resultObject = new ResultObject(true);
        try {
            JSONObject jsonObject = FaceUtil.getRequestInit().personCreate(new PostParameters().setPersonName(personName).setFaceId(faceId).setGroupId(groupId).setTag(tag));
            Person person = GsonUtil.fromJson(jsonObject.toString(), Person.class);
            resultObject.setMessage("创建成功,并且加入group: " + groupId);
            resultObject.setObject(person);
        } catch (FaceppParseException e) {
            resultObject.setSuccess(false);
            resultObject.setMessage("创建人失败");
            e.printStackTrace();
        }
        return resultObject;
    }

    /**
     * 比较两张脸的相似度,可以自定义设置
     * @param faceId1
     * @param faceId2
     * @return
     */
    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    @ResponseBody
    public ResultObject compare(@RequestParam(value = "faceId1", defaultValue = "a2a40ce6c57ef905dd1b5ec2b171fecd") String faceId1,
                                @RequestParam(value = "faceId2", defaultValue = "933e330ff28b134cf9fd5aca27f32ec1") String faceId2) {
        ResultObject resultObject = new ResultObject(true);
        try {
            JSONObject jsonObject = FaceUtil.getRequestInit().recognitionCompare(new PostParameters().setFaceId1(faceId1).setFaceId2(faceId2));
            resultObject.setMessage("成功");
            resultObject.setObject(jsonObject.toString());
        } catch (FaceppParseException e) {
            resultObject.setSuccess(false);
            resultObject.setMessage("失败");
            e.printStackTrace();
        }
        return resultObject;
    }


    @RequestMapping(value = "/getpersonlist", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersonList() throws FaceppParseException, JSONException {
        JSONObject jsonObject = FaceUtil.getRequestInit().infoGetPersonList();
        //返回的的内容还有response_code
        return GsonUtil.fromJson(jsonObject.get("person").toString(), new TypeToken<List<Person>>() {
        }.getType());
    }


    @RequestMapping(value = "/getgrouplist", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getGroupList() throws FaceppParseException, JSONException {
        JSONObject jsonObject = FaceUtil.getRequestInit().infoGetGroupList();
        //返回的的内容还有response_code
        return GsonUtil.fromJson(jsonObject.get("group").toString(), new TypeToken<List<Person>>() {
        }.getType());
    }


}
