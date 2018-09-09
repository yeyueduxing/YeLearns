package com.yeyue.learns.model.api.service;

import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.wechat.WeChatHttpRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
  *@describe 微信信息
  *@author li.xiao
  *@time 2018-1-11 11:33
  */
public interface WeChatService {

    /**
     * 微信精选列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WECHAT})
    @GET("/{type}/")
    Observable<WeChatHttpRequest> getWXNew(@Path("type") String type, @Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);

    /**
     * 微信主页列表
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WECHAT})
    @GET("weixin/home/")
    Observable<WeChatHttpRequest> getWXHome(@Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);

}
