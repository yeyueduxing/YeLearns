package com.yeyue.learns.model.api.cache;

import com.haibin.calendarview.Calendar;
import com.yeyue.learns.enity.bizhi.BizhiDetailHttpRequest;
import com.yeyue.learns.enity.bizhi.HomePage;
import com.yeyue.learns.enity.bizhi.HotSearch;
import com.yeyue.learns.enity.bizhi.UserDetail;
import com.yeyue.learns.enity.bizhi.WalDetail;
import com.yeyue.learns.enity.bizhi.WalRecommend;
import com.yeyue.learns.enity.diycode.DiyTopContent;
import com.yeyue.learns.enity.gank.GankData;
import com.yeyue.learns.enity.gank.GankHttpRequest;
import com.yeyue.learns.enity.movie.MovieBean;
import com.yeyue.learns.enity.movie.MovieCelebrity;
import com.yeyue.learns.enity.movie.MovieHttpRequest;
import com.yeyue.learns.enity.movie.MoviePhotoRequest;
import com.yeyue.learns.enity.movie.MovieUsBoxRequest;
import com.yeyue.learns.model.api.HttpRequest;
import com.yeyue.library.data.BannerList;
import com.yeyue.library.data.BaseItem;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

/**
 * Created by jess on 8/30/16 13:53
 * Contact with jess.yan.effort@gmail.com
 */
public interface CommonCache {

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<MovieBean> getMovieBean(Observable<MovieBean> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<HomePage> getBizhiHomePage(Observable<HomePage> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);
    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<WalRecommend> getWalRecommend(Observable<WalRecommend> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);


    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<MovieCelebrity> getMovieCelebrity(Observable<MovieCelebrity> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);
    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<MoviePhotoRequest> getMoviePhotoRequest(Observable<MoviePhotoRequest> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<MovieHttpRequest> getMovieHttpRequest(Observable<MovieHttpRequest> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<MovieUsBoxRequest> getMovieUsBoxRequest(Observable<MovieUsBoxRequest> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);


    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<List<BaseItem>> getListDataCache(Observable<List<BaseItem>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<GankHttpRequest<GankData>> getGankIoData(Observable<GankHttpRequest<GankData>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);


    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<List<Calendar>> getCalendarDataCache(Observable<List<Calendar>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);


    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<BannerList> getBannerList(Observable<BannerList> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<DiyTopContent> getDiyTopContent(Observable<DiyTopContent> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<UserDetail> getUserDetail(Observable<UserDetail> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<HomePage> getHomePage(Observable<HomePage> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<HttpRequest<WalDetail>> getWalDetailDetail(Observable<HttpRequest<WalDetail>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<HttpRequest<HotSearch>> getHotSearch(Observable<HttpRequest<HotSearch>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
    Observable<BizhiDetailHttpRequest> getBizhiDetailHttpRequest(Observable<BizhiDetailHttpRequest> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);


}
