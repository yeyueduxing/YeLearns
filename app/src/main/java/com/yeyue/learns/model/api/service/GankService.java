package com.yeyue.learns.model.api.service;

import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.HttpSkins;
import com.yeyue.learns.enity.gank.GankData;
import com.yeyue.learns.enity.gank.GankHistory;
import com.yeyue.learns.enity.gank.GankHttpDay;
import com.yeyue.learns.enity.gank.GankHttpRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * 存放关于用户的一些api
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface GankService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/Android/10/1
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.GANK})
    @GET("/api/data/{type}/{pre_page}/{page}")
    Observable<GankHttpRequest<GankData>> getGankIoData(@Path("type") String id, @Path("page") int page, @Path("pre_page") int pre_page);


    /**
     * 每日数据
     * eg: http://gank.io/api/day/2015/08/07
     * @param year
     * @param month
     * @param day
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.GANK})
    @GET("/api/day/{year}/{month}/{day}")
    Observable<GankHttpDay> getGankIoDay(@Path("year") int year, @Path("month") int month, @Path("day") int day);


    /**
     * 获取发过干货日期接口
     * eg: http://gank.io/api/day/history
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.GANK})
    @GET("/api/day/history")
    Observable<GankHistory> getGankIoHistory();

    /**
     * 随机数据：http://gank.io/api/random/data/分类/个数
     * 数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * 个数： 数字，大于0
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.GANK})
    @GET("/api/random/data/{type}/{limit}")
    Observable<GankHttpRequest<GankData>> getGankIoRadom(@Path("type") String type, @Path("limit") int limit);

    /**
     * 获取皮肤
     * http://111.230.154.222/yeSkin.json
     * @return
     */
    @GET("http://111.230.154.222/yeSkin.json")
    Observable<HttpSkins> getSkinList();

}
