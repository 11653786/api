package com.yt.activemq.entity.face;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class Attribute {

    private Age age;
    private Gender gender;
    private Gender race;
    private Smiling smiling;

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getRace() {
        return race;
    }

    public void setRace(Gender race) {
        this.race = race;
    }

    public Smiling getSmiling() {
        return smiling;
    }

    public void setSmiling(Smiling smiling) {
        this.smiling = smiling;
    }
}
