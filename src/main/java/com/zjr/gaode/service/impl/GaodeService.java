package com.zjr.gaode.service.impl;

import com.zjr.gaode.service.IGaodeService;
import com.zjr.gaode.util.TimeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 11:00 2018/1/8
 * @Description:
 */
@Service
public class GaodeService implements IGaodeService {

    /**
     * @param [origins---起点坐标（经纬度）, destination---终点坐标（经纬度）]
     * @return java.lang.String
     * @author ZhangJiaRen
     * @date 2018/1/8 11:37
     * @description 骑行路径规划---骑行距离
     */
    @Override
    public  String cyclingDistance(String origins, String destination) {
        JSONArray jsonArray = getJsonArray(origins, destination);
//        起终点的骑行距离（米）
        String distance = jsonArray.getJSONObject(0).getString("distance");
//        米转成公里
        distance = String.valueOf(Float.parseFloat(distance) / 1000L);
        distance += "公里";
        return distance;
    }

    /**
     * @param [origins---起点坐标, destination---终点坐标]
     * @return java.lang.String
     * @author ZhangJiaRen
     * @date 2018/1/8 12:40
     * @description 骑行路径规划---骑行时间
     */
    @Override
    public  String cyclingTime(String origins, String destination) {
        JSONArray jsonArray = getJsonArray(origins, destination);
//        起终点的骑行时间（秒）
        Long time = jsonArray.getJSONObject(0).getLong("duration");
//        秒转某天某时某分某秒
        String dateTime = TimeUtil.formatDateTime(time);
        return dateTime;
    }

    /**
     * @param [origins, destination]
     * @return net.sf.json.JSONArray
     * @author ZhangJiaRen
     * @date 2018/1/8 14:35
     * @description
     */
    private  JSONArray getJsonArray(String origins, String destination) {
        JSONObject jsonObject = IGaodeService.getJsonObject(origins, destination);
        JSONArray pathArray = jsonObject.getJSONObject("data").getJSONArray("paths");
        return pathArray;
    }


}
