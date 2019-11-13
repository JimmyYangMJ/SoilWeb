package com.mvc.pojo;

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
    private int interval;
    /** 结点位置坐标 */
    private String location;
    /** 信息修改时间 */
    private String last_update;



    public SoilNode() {
        super();
    }

    public SoilNode(int node, String state, int interval, String location, String last_update) {
        this.node = node;
        this.state = state;
        this.interval = interval;
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

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "SoilNode{" +
                "nodeId=" + node +
                ", status=" + state +
                ", interval=" + interval +
                ", location=" + location +
                ", dateTime=" + last_update +
                '}';
    }
}
