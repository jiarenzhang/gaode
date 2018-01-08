package com.zjr.gaode.util;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 12:43 2018/1/8
 * @Description: 将秒数转为*天*小时*分*秒
 */
public class TimeUtil {
    public static String formatDateTime(long mss) {
        String dateTimes = null;
        long days = mss / (60 * 60 * 24);
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / 60;
        long seconds = mss % 60;
        if (days > 0) {
            dateTimes = days + "天" + hours + "小时" + minutes + "分钟"
                    + seconds + "秒";
        } else if (hours > 0) {
            dateTimes = hours + "小时" + minutes + "分钟"
                    + seconds + "秒";
        } else if (minutes > 0) {
            dateTimes = minutes + "分钟"
                    + seconds + "秒";
        } else {
            dateTimes = seconds + "秒";
        }

        return dateTimes;
    }
}
