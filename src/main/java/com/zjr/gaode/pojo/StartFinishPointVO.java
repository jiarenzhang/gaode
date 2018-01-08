package com.zjr.gaode.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 15:05 2018/1/8
 * @Description: 起终点封装
 */
public class StartFinishPointVO implements Serializable {

    private String origins;
    private String destination;

    @ApiModelProperty("起点坐标（经纬度）")
    public String getOrigins() {
        return origins;
    }

    public void setOrigins(String origins) {
        this.origins = origins;
    }

    @ApiModelProperty("终点坐标（经纬度）")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
