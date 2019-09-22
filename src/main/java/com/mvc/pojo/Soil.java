package com.mvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Soil {
    private Integer id;

    private Integer node;

    private Double humidity;

    private Date times;


    public Soil(Integer id, Integer node, Double humidity, Date times, Date updateTime) {
        this.id = id;
        this.node = node;
        this.humidity = humidity;
        this.times = times;
    }

    public Soil() {
        super();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNode() {
        return node;
    }

    public Double getHumidity() {
        return humidity;
    }

    @JsonFormat(pattern = "yyyy-MM-dd- HH:mm:ss", timezone = "GMT")
    public Date getTimes() {
        return times;
    }

    @Override
    public String toString() {
        return "Soil{" +
                "id=" + id +
                ", node=" + node +
                ", humidity=" + humidity +
                ", createTime=" + times +
                '}';
    }
}
