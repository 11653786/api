package com.yt.activemq.entity.person;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class Person {

    //成功被加入的group数量
    private int added_group;
    //成功加入的face数量
    private int added_face;
    //person相关的tag
    private String tag;
    //相应person的name
    private String person_name;
    private String person_id;

    public int getAdded_group() {
        return added_group;
    }

    public void setAdded_group(int added_group) {
        this.added_group = added_group;
    }

    public int getAdded_face() {
        return added_face;
    }

    public void setAdded_face(int added_face) {
        this.added_face = added_face;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }
}
