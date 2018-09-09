package com.yeyue.library.utils;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.yeyue.library.constant.YeConstant;

import java.util.regex.Pattern;

/**
 * @author li.xiao
 * @describe
 * @time 2018-1-23 9:27
 */
public class YeSpUtils {
    /**
     * 获取网络请求重试次数
     */
    public static int getRetryMax() {
        return SPUtils.getInstance(YeConstant.ShareP.SPNAME).getInt(YeConstant.ShareP.NETRETRY_MAX,1);
    }

    public static int getRetryDelaySecond() {
        return SPUtils.getInstance(YeConstant.ShareP.SPNAME).getInt(YeConstant.ShareP.NETRETRY_DELAY,1);
    }

    public static int getRecyanimationType() {
        return strToInteger(SPUtils.getInstance(YeConstant.ShareP.SPNAME).getString(YeConstant.ShareP.RECYANIMATION),1);
    }

    /**
     * 获取加载动画的类型
     */
    public static int getLoadViewIndicator() {
        return strToInteger(SPUtils.getInstance(YeConstant.ShareP.SPNAME).getString(YeConstant.ShareP.LOAD_INDICATOR),3);
    }

    public static void setLoadViewIndicator(int indicator) {
       SPUtils.getInstance(YeConstant.ShareP.SPNAME).put(YeConstant.ShareP.LOAD_INDICATOR,indicator+"");
    }

    public static int strToInteger(String str,int defalut) {
        int num = defalut;
        if(ObjectUtils.isEmpty(str) || !isInteger(str)){
            return num;
        }
        num = Integer.valueOf(str);
        return num;
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
