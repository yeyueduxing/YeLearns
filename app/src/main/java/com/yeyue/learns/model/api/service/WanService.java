package com.yeyue.learns.model.api.service;

import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.wan.WanArticle;
import com.yeyue.learns.enity.wan.WanBanner;
import com.yeyue.learns.enity.wan.WanDataResponse;
import com.yeyue.learns.enity.wan.WanFriend;
import com.yeyue.learns.enity.wan.WanHotKey;
import com.yeyue.learns.enity.wan.WanKnowledgeSystem;
import com.yeyue.learns.enity.wan.WanUser;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
  *@describe 玩安卓
  *@author li.xiao
  *@time 2018-2-26 16:26
  */
public interface WanService {

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     *
     * @param page page
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/article/list/{page}/json")
    Observable<WanDataResponse<WanArticle>> getHomeArticles(@Path("page") int page);

    /**
     * 首页Banner
     *
     * @return BannerResponse
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/banner/json")
    Observable<WanDataResponse<List<WanBanner>>> getHomeBanners();


    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return BannerResponse
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/tree/json")
    Observable<WanDataResponse<List<WanKnowledgeSystem>>> getKnowledgeSystems();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0/json?cid=168
     *
     * @param page page
     * @param cid  cid
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/article/list/{page}/json")
    Observable<WanDataResponse<WanArticle>> getKnowledgeSystemArticles(@Path("page") int page, @Query("cid") int cid);


    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/friend/json")
    Observable<WanDataResponse<List<WanFriend>>> getHotFriends();

    /**
     * 大家都在搜
     * http://www.wanandroid.com/hotkey/json
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/hotkey/json")
    Observable<WanDataResponse<List<WanHotKey>>> getHotKeys();

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     *
     * @param page page
     * @param k    POST search key
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    Observable<WanDataResponse<WanArticle>> getSearchArticles(@Path("page") int page, @Field("k") String k);


    /**
     * 登录
     *
     * @param username username
     * @param password password
     * @return Deferred<User>
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/user/login")
    @FormUrlEncoded
    Observable<WanDataResponse<WanUser>> login(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     *
     * @param username   username
     * @param password   password
     * @param repassword repassword
     * @return Deferred<User>
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/user/register")
    @FormUrlEncoded
    Observable<WanDataResponse<WanUser>> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 收藏文章
     *
     * @param id id
     * @return Deferred<DataResponse>
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/lg/collect/{id}/json")
    Observable<WanDataResponse> addCollectArticle(@Path("id") int id);

    /**
     * 收藏站外文章
     *
     * @param title  title
     * @param author author
     * @param link   link
     * @return Deferred<DataResponse>
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/lg/collect/add/json")
    @FormUrlEncoded
    Observable<WanDataResponse> addCollectOutsideArticle(@Field("title") String title, @Field("author") String author, @Field("link") String link);

    /**
     * 删除收藏文章
     *
     * @param id       id
     * @param originId -1
     * @return Deferred<DataResponse>
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<WanDataResponse> removeCollectArticle(@Path("id") int id, @Field("originId") int originId);


    /**
     * 获取自己收藏的文章列表
     *
     * @param page page
     * @return Deferred<Article>
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/lg/collect/list/{page}/json")
    Observable<WanDataResponse<WanArticle>> getCollectArticles(@Path("page") int page);

    /**
     * 我的书签
     * http://www.wanandroid.com/lg/collect/usertools/json
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @GET("/lg/collect/usertools/json")
    Observable<WanDataResponse<List<WanFriend>>> getBookmarks();

    /**
     * 编辑书签
     * http://www.wanandroid.com/lg/collect/updatetool/json
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/lg/collect/usertools/json")
    @FormUrlEncoded
    Observable<WanDataResponse> editBookmark(@Field("id") int id, @Field("name") String name, @Field("link") String link);

    /**
     * 删除书签
     * http://www.wanandroid.com/lg/collect/deletetool/json
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.WAN})
    @POST("/lg/collect/usertools/json")
    @FormUrlEncoded
    Observable<WanDataResponse> delBookmark(@Field("id") int id);

}
