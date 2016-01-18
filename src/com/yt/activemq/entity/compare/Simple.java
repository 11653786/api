package com.yt.activemq.entity.compare;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class Simple {
    private String session_id;
    private double similarity;
    private SimpleCompare component_similarity;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public SimpleCompare getComponent_similarity() {
        return component_similarity;
    }

    public void setComponent_similarity(SimpleCompare component_similarity) {
        this.component_similarity = component_similarity;
    }
}
