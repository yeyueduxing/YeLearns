package com.yeyue.learns.model.api.service;


import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.bizhi.AlbumDetail;
import com.yeyue.learns.enity.bizhi.BizhiAlbumBean;
import com.yeyue.learns.enity.bizhi.BizhiBean;
import com.yeyue.learns.enity.bizhi.BizhiDetailHttpRequest;
import com.yeyue.learns.enity.bizhi.HomePage;
import com.yeyue.learns.enity.bizhi.HotSearch;
import com.yeyue.learns.enity.bizhi.HttpAlbum;
import com.yeyue.learns.enity.bizhi.HttpAlbumRequest;
import com.yeyue.learns.enity.bizhi.HttpCategory;
import com.yeyue.learns.enity.bizhi.HttpVertical;
import com.yeyue.learns.enity.bizhi.HttpVideo;
import com.yeyue.learns.enity.bizhi.HttpWallpaper;
import com.yeyue.learns.enity.bizhi.SearchAll;
import com.yeyue.learns.enity.bizhi.SearchTags;
import com.yeyue.learns.enity.bizhi.UserDetail;
import com.yeyue.learns.enity.bizhi.VerCategory;
import com.yeyue.learns.enity.bizhi.VideoBean;
import com.yeyue.learns.enity.bizhi.VideoCategory;
import com.yeyue.learns.enity.bizhi.WalCategory;
import com.yeyue.learns.enity.bizhi.WalRecommend;
import com.yeyue.learns.model.api.HttpRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * 存放关于用户的一些api
 * Created by jess on 8/5/16 12:05
 * contact with jess.yan.effort@gmail.com
 */
public interface BizhiService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";


    /**
     * 获取首页推荐数据
     * http://service.picasso.adesk.com/v3/homepage?limit=30&first=2&order=hot
     * @param limit
     * @param skip 从多少开始
     * @param order
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v3/homepage")
    Observable<HomePage> getHomepage(@Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 获取首页壁纸分类
     * http://service.picasso.adesk.com/v1/wallpaper/category
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/wallpaper/category")
    Observable<HttpRequest<WalCategory>> getWalCategory();

    /**
     * 壁纸分类详情列表
     * http://service.picasso.adesk.com/v1/wallpaper/category/4e4d610cdf714d2966000000/wallpaper?limit=30&skip=2&order=new
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("v1/wallpaper/category/{cId}/wallpaper")
    Observable<HttpWallpaper<BizhiBean>> getWalCategoryList(@Path("cId") String cid, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 壁纸分类专辑列表
     * http://service.picasso.adesk.com/v1/wallpaper/category/4e4d610cdf714d2966000000/album?limit=10&adult=false&first=1&order=new
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("v1/wallpaper/category/{cId}/album")
    Observable<HttpAlbumRequest<BizhiAlbumBean>> getWalCategoryAlbum(@Path("cId") String cid, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 获取首页壁纸最新
     * http://service.picasso.adesk.com/v1/wallpaper/wallpaper?limit=30&first=40&order=new
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/wallpaper/wallpaper")
    Observable<HttpWallpaper<BizhiBean>> getWalNew(@Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 获取首页壁纸详情
     * http://service.picasso.adesk.com/v2/wallpaper/wallpaper/59f3082ae7bce729d564ff6f/comment
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("v2/wallpaper/wallpaper/{Id}/comment")
    Observable<BizhiDetailHttpRequest> getWalDetail(@Path("Id") String id);


    /**
     * 获取竖屏壁纸数据
     * http://service.picasso.adesk.com/v1/vertical/vertical?limit=30&first=1&order=hot
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/vertical/vertical")
    Observable<HttpVertical<BizhiBean>> getVerticalBizhi(@Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 获取竖屏壁纸分类
     * http://service.picasso.adesk.com/v1/vertical/category
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/vertical/category")
    Observable<HttpCategory<VerCategory>> getVerCategory();

    /**
     * 竖屏分类详情列表
     * http://service.picasso.adesk.com/v1/vertical/category/4e4d610cdf714d2966000000/vertical?limit=30&adult=false&first=1&order=new
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("v1/vertical/category/{cId}/vertical")
    Observable<HttpVertical<BizhiBean>> getVerCategoryList(@Path("cId") String cid, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 获取首页壁纸专辑
     * http://service.picasso.adesk.com/v1/wallpaper/album?limit=10&first=1&order=new
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/wallpaper/album")
    Observable<HttpAlbum> getAlbum(@Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 获取专辑详情页
     * http://service.picasso.adesk.com/v1/wallpaper/album/5a24cd3ae7bce7253c78ae3f/wallpaper?limit=30&adult=false&first=1&order=new
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI,"User-Agent: picasso,186,xiaomi"})
    @GET("/v1/wallpaper/album/{albumId}/wallpaper")
    Observable<HttpRequest<AlbumDetail>> getAlbumDetail(@Path("albumId") String albumId, @Query("limit") int limit, @Query("skip") int first, @Query("order") String order);


    /**
     * 每日精选
     * http://service.picasso.adesk.com/v1/wallpaper/recommend?limit=6&adult=false&first=1
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/wallpaper/recommend")
    Observable<WalRecommend> getWalRecommend(@Query("limit") int limit, @Query("skip") int skip, @Query("first") int first);

    /**
     * 视频推荐
     * https://service.videowp.adesk.com/v1/videowp/featured?limit=30&adult=false&first=1&order=hot
     * @return
     */
    @GET("https://service.videowp.adesk.com/v1/videowp/{type}")
    Observable<HttpVideo<VideoBean>> getVideoList(@Path("type") String type, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    /**
     * 视频分类详情
     * https://service.videowp.adesk.com/v1/videowp/category/5930e065e7bce72ce01371b1?limit=30&adult=false&first=1&order=new
     * @param limit
     * @param skip
     * @param order
     * @return
     */
    @GET("https://service.videowp.adesk.com/v1/videowp/category/{cate_id}")
    Observable<HttpVideo<VideoBean>> getVideoCateGoryDetail(@Path("cate_id") String cate_id, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);


    /**
     * 获取视频壁纸分类
     * https://service.videowp.adesk.com/v1/videowp/category
     * @return
     */
    @GET("https://service.videowp.adesk.com/v1/videowp/category")
    Observable<HttpCategory<VideoCategory>> getVideoCategory();


    /**
     * 获取用户信息
     * http://service.picasso.adesk.com/v1/user/5965cd0be7bce7312ef79fbf
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("v1/user/{uId}")
    Observable<HttpRequest<UserDetail>> getUserDetail(@Path("uId") String uId);

    /**
     * 用户横屏壁纸
     * http://service.picasso.adesk.com/v1/user/5965cd0be7bce7312ef79fbf/wallpaper?action=upload&limit=30&adult=false&first=1&order=new
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/user/{uId}/wallpaper")
    Observable<HttpWallpaper<BizhiBean>> getUserWallPaper(@Path("uId") String uId, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order, @Query("action") String action);
    /**
     * 用户竖屏壁纸
     * http://service.picasso.adesk.com/v1/user/5965cd0be7bce7312ef79fbf/vertical?action=upload&limit=30&adult=false&first=1&order=new
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/user/{uId}/vertical")
    Observable<HttpVertical<BizhiBean>> getUserVertical(@Path("uId") String uId, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order, @Query("action") String action);
    /**
     * 用户专辑
     * http://service.picasso.adesk.com/v1/user/5965cd0be7bce7312ef79fbf/album?uid=&limit=30&adult=false&first=1&order=new
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/user/{uId}/album")
    Observable<HttpAlbumRequest<BizhiAlbumBean>> getUserAlbum(@Path("uId") String uId, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);



    /**
     * 获取热门搜索
     * http://service.picasso.adesk.com/v1/push/keyword?first=0&adult=false
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.BIZHI})
    @GET("/v1/push/keyword")
    Observable<HttpRequest<HotSearch>> getSearchKeyword(@Query("first") int first);
    /**
     * 搜索-全部
     * http://so.picasso.adesk.com/v1/search/all/resource/%E7%BE%8E%E5%A5%B3?limit=30&first=1
     */
    @GET("http://so.picasso.adesk.com/v1/search/all/resource/{Query}")
    Observable<HttpRequest<SearchAll>> getSearchAll(@Path("Query") String Query, @Query("limit") int limit, @Query("skip") int skip);

    /**
     * 搜索-分类
     * http://so.picasso.adesk.com/v1/search/all/resource/%E7%BE%8E%E5%A5%B3?limit=30&first=1
     */
    @GET("http://so.picasso.adesk.com/v1/search/{tag}/resource/{Query}")
    Observable<HttpRequest<SearchTags>> getSearchTag(@Path("tag") String tag, @Path("Query") String Query, @Query("limit") int limit, @Query("skip") int skip);


}
