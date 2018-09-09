package com.yeyue.library.utils;


import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
  *@describe SP单字段为数组的操作
  *@author li.xiao
  *@time 2017-9-7 9:42
  */
public class SPArrayUtils {

    public static List<String> getKeyValues(String spName,String spKey){
        if( StringUtils.isEmpty(spName) ||StringUtils.isEmpty(spKey) ){
            return null;
        }
        List<String> values = new ArrayList<>();
        String value = SPUtils.getInstance(spName).getString(spKey);
        //存储进入Sp的为JSON字符串，解析字符串
        Gson gson = new Gson();
        if(!StringUtils.isEmpty(value)){
            try{
                values = gson.fromJson(value,new TypeToken<List<String>>() {}.getType());
            }catch (Exception e){
                values = new ArrayList<>();
            }
        }
        return values;
    }
    /**
      *@describe 添加和更新数据，添加的数据会移动到顶部
      *@author li.xiao
      *@time 2017-9-7 9:54
      */
    public static boolean updateKey(String key,String spName,String spKey){
        if( StringUtils.isEmpty(key) ){
            return false;
        }
        List<String> values = getKeyValues(spName,spKey);
        if(values!=null && values.size()>0){
            values.remove(key);
        }else {
            values = new ArrayList<>();
        }
        values.add(key);
        Gson gson = new Gson();
        SPUtils.getInstance(spName).put(spKey,gson.toJson(values));
        return true;
    }

    public static boolean delKey(String key,String spName,String spKey){
        if( StringUtils.isEmpty(key) ){
            return false;
        }
        List<String> values = getKeyValues(spName,spKey);
        if(values!=null && values.size()>0){
            values.remove(key);
        }else{
            values = new ArrayList<>();
        }
        Gson gson = new Gson();
        SPUtils.getInstance(spName).put(spKey,gson.toJson(values));
        return true;
    }

    public static boolean cleanKey(String spName,String spKey){
        if( StringUtils.isEmpty(spName) ||StringUtils.isEmpty(spKey) ){
            return false;
        }
        SPUtils.getInstance(spName).remove(spKey);
        return true;
    }
}
