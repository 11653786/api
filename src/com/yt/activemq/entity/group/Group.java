package com.yt.activemq.entity.group;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class Group {
    //成功加入的person数量
    private int added_person;
    //group相关的tag
    private String tag;
    //相应group的name;
    private String group_name;
    private String group_id;

    public int getAdded_person() {
        return added_person;
    }

    public void setAdded_person(int added_person) {
        this.added_person = added_person;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }
}
