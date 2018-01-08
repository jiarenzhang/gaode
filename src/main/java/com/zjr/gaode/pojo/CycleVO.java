package com.zjr.gaode.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 16:37 2018/1/8
 * @Description: 骑行返回结果的封装
 */
public class CycleVO {

    private   String content;

    @ApiModelProperty("返回给前端的内容")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
