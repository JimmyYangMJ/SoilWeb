package com.mvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 结点信息
 * @author ymj
 * @Date： 2019/11/13 20:10
 */
public class SoilNode {

    /** 结点编号*/
    private int node;
    /** 结点状态 */
    private String state;
    /** 监测频率， 单位秒*/
    private int interval_s;
    /** 结点位置坐标 */
    private String location;
    /** 信息修改时间 */
    private Date last_update;



    public SoilNode() {
        super();
    }

    public SoilNode(int node, String state, int interval_s, String location, Date last_update) {
        this.node = node;
        this.state = state;
        this.interval_s = interval_s;
        this.location = location;
        this.last_update = last_update;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getInterval_s() {
        return interval_s;
    }

    public void setInterval_s(int interval_s) {
        this.interval_s = interval_s;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "SoilNode{" +
                "nodeId=" + node +
                ", status=" + state +
                ", interval=" + interval_s +
                ", location=" + location +
                ", dateTime=" + last_update +
                '}';
    }
}
