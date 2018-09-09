package com.yeyue.learns.model.api.service;

import com.yeyue.learns.constant.Constant;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MovieCelebrity;
import com.yeyue.learns.enity.movie.MovieHttpRequest;
import com.yeyue.learns.enity.movie.MoviePhotoRequest;
import com.yeyue.learns.enity.movie.MovieUsBoxRequest;

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
public interface MovieService {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";


    /**
     * 正在上映
     *https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=somemessage&udid=dddddddddddddddddddddd
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @param city 城市名称 上海/北京
     * @param start 分页使用，表示第几页
     * @param count 分页使用，表示数量
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/{type}")
    Observable<MovieHttpRequest> getHotPlayMovies(@Path("type") String type,@Query("apikey") String apikey, @Query("city") String city, @Query("start") int start, @Query("count") int count);

    /**
     * 口碑榜
     *https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=somemessage&udid=dddddddddddddddddddddd
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/weekly")
    Observable<MovieHttpRequest> getWeekly(@Query("apikey") String apikey);

    /**
     * 北美票房榜
     *https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=somemessage&udid=dddddddddddddddddddddd
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/{type}")
    Observable<MovieUsBoxRequest> getUsBox(@Path("type") String type,@Query("apikey") String apikey);

    /**
     * Top250
     *https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=somemessage&udid=dddddddddddddddddddddd
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @param start 分页使用，表示第几页
     * @param count 分页使用，表示数量
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/top250")
    Observable<MovieHttpRequest> getTop250(@Query("apikey") String apikey, @Query("start") int start, @Query("count") int count);


    /**
     *http://api.douban.com/v2/movie/subject/26865690?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&client=something&udid=dddddddddddddddddddddd
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @param city 城市名称 上海/北京
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/subject/{subjectId}")
    Observable<MovieBean> getMovieDetail(@Path("subjectId")String subjectId, @Query("apikey") String apikey, @Query("city") String city);

    /**
     * 电影剧照
     *https://api.douban.com//v2/movie/celebrity/1054395?apikey=0b2bdeda43b5688921839c8ecb20399b
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/subject/{Id}/{type}")
    Observable<MoviePhotoRequest> getMoviePhotos(@Path("Id")String id,@Path("type")String type,  @Query("apikey") String apikey, @Query("start") int start, @Query("count") int count);

    /**
     * 获取影人信息
     *https://api.douban.com//v2/movie/celebrity/1054395?apikey=0b2bdeda43b5688921839c8ecb20399b
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/celebrity/{Id}")
    Observable<MovieCelebrity> getCelebrity(@Path("Id")String id, @Query("apikey") String apikey);

    /**
     * 电影搜索
     *https://api.douban.com//v2/movie/celebrity/1054395?apikey=0b2bdeda43b5688921839c8ecb20399b
     * @param apikey 固定值 0b2bdeda43b5688921839c8ecb20399b
     * @return
     */
    @Headers({DOMAIN_NAME_HEADER+ Constant.Domain.MOVIE})
    @GET("/v2/movie/search")
    Observable<MovieHttpRequest> getMovieSearch(@Query("tag")String tag, @Query("q")String q, @Query("apikey") String apikey, @Query("start") int start, @Query("count") int count);

}
