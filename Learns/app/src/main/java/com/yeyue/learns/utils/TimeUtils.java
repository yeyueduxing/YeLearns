package com.yeyue.learns.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TimeUtils {

    public static String computePastTime(String time) {
        // Log.v(TAG, "computePastTime: " + time);
        String result = "刚刚";
        //2017-02-13T01:20:13.035+08:00
        time = time.replace("T", " ");
        time = time.substring(0, 22);
        // Log.v(TAG, "computePastTime time: " + time);
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.SIMPLIFIED_CHINESE);
        try {
            Date t = simpleDateFormat.parse(time);
            Date now = new Date(System.currentTimeMillis());
            long diff = (now.getTime() - t.getTime()) / 1000;
            if (diff < 60) {
                result = "刚刚";
            } else if ((diff /= 60) < 60) {
                result = diff + "分钟前";
            } else if ((diff /= 60) < 24) {
                result = diff + "小时前";
            } else if ((diff /= 24) < 30) {
                result = diff + "天前";
            } else if ((diff /= 30) < 12) {
                result = diff + "月前";
            } else {
                diff /= 12;
                result = diff + "年前";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Log.v(TAG, "computePastTime result: " + result);
        return result;
    }
    public static String timeFormat(long timeMillis, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.CHINA);
        return format.format(new Date(timeMillis));
    }
    public static String formatTime(String time) {
        // Log.v(TAG, "formatTime: " + time);
        //2017-02-13T01:20:13.035+08:00
        time = time.replace("T", " ");
        time = time.substring(0, 16);
        // Log.v(TAG, "formatTime result: " + time);
        return time;
    }
}
