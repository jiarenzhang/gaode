package com.zjr.gaode.service;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 11:52 2018/1/8
 * @Description:
 */
public interface IGaodeService {
    /**
     * @param [allConfigUrl]
     * @return java.lang.String
     * @author ZhangJiaRen
     * @date 2018/1/8 11:57
     * @description
     */
    static String getHttpResponse(String allConfigUrl) {
        BufferedReader in = null;
        StringBuffer result = null;
        try {
            // url请求中如果有中文，要在接收方用相应字符转码
            URI uri = new URI(allConfigUrl);
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Content-type", "text/html");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");
            connection.connect();
            result = new StringBuffer();
            // 读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @param [origins---起点坐标, destination---终点坐标]
     * @return net.sf.json.JSONObject
     * @author ZhangJiaRen
     * @date 2018/1/8 12:34
     * @description
     */
    static JSONObject getJsonObject(String origins, String destination) {
        String url = "http://restapi.amap.com/v4/direction/bicycling?" + "origin=" + origins + "&destination="
                + destination + "&key=afee8329043f7ebe593f6af4a93b81a1";
        JSONObject jsonobject = JSONObject.fromObject(getHttpResponse(url));
        return jsonobject;
    }

     String cyclingTime(String origins, String destination);

     String cyclingDistance(String origins, String destination);


}
